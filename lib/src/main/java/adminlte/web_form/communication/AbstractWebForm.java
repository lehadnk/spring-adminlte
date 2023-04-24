package adminlte.web_form.communication;

import adminlte.web_form.communication.form_elements.*;
import adminlte.web_form.dto.FileData;
import adminlte.web_form.dto.LocalizedField;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

abstract public class AbstractWebForm<TRequest> {
    public LinkedHashMap<String, WebFormElementInterface> elements = new LinkedHashMap<>();
    public Submit submitButton;
    public String actionUrl;
    public String enctype = "application/x-www-form-urlencoded";

    final private ObjectMapper objectMapper;

    public AbstractWebForm() {
        this.objectMapper = new ObjectMapper();
        this.objectMapper.findAndRegisterModules();
    }

    public String getActionUrl() {
        return this.actionUrl;
    }

    public AbstractWebForm<TRequest> setActionUrl(String actionUrl) {
        this.actionUrl = actionUrl;
        return this;
    }

    public String getEnctype() {
        return this.enctype;
    }

    public void setEnctype(String enctype) {
        this.enctype = enctype;
    }

    public AbstractWebForm<TRequest> multipart() {
        this.setEnctype("multipart/form-data");
        return this;
    }

    protected void addElement(String name, WebFormElementInterface element) {
        this.elements.put(name, element);
    }

    protected void addSubmitButton(Submit submit) {
        this.submitButton = submit;
    }

    public void hydrateFromRequest(TRequest dto) {
        if (dto instanceof Record record) {
            this.hydrateFromRecord(record);
            return;
        }

        try {
            for (var field : getAllFields(dto.getClass())) {
                if (this.elements.containsKey(field.getName())) {
                    field.setAccessible(true);
                    Object valueObject = null;

                        valueObject = field.get(dto);

                    var value = this.hydrateElement(field.getName(), valueObject);

                    // handling nullable property
                    var formElement = this.elements.get(field.getName());
                    if (value == null && formElement instanceof Input input && input.getNullable()) {
                        field.set(dto, null);
                    }
                }
            }
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    private static List<Field> getAllFields(Class<?> type) {
        if (type.isInterface() || type.isArray() || type.isEnum() || type.isEnum() || type.isRecord()) {
            return List.of();
        }
        if (type.getCanonicalName().equals("java.lang.Object")) {
            return List.of();
        }
        var fields = Arrays.asList(type.getDeclaredFields());
        var superclassFields = getAllFields(type.getSuperclass());
        var result = new ArrayList<Field>(superclassFields.size() + fields.size());
        result.addAll(fields);
        result.addAll(superclassFields);
        return result;
    }

    public Object hydrateElement(String fieldName, Object valueObject) {
        String value;

        if (valueObject == null) {
            value = null;
        } else if (valueObject instanceof String stringValue && stringValue.isEmpty()) {
            value = stringValue;
            var elem = this.elements.get(fieldName);
            if (elem instanceof Input input) {
                if (input.getNullable()) {
                    value = null;
                }
            }
        } else if (valueObject instanceof LocalizedField fileData) {
            var input = (Localizable) this.elements.get(fieldName);
            assert input.getGlossaryKey().equals(fileData.getKey());
            var localizedFieldValue = fileData.getLocalization().toMap();
            input.setValue(localizedFieldValue);
            return localizedFieldValue;
        } else if (valueObject instanceof FileData fileData) {
            value = fileData.getFileUrl();
        } else if (valueObject instanceof Integer || valueObject instanceof Long || valueObject instanceof Double || valueObject instanceof Float || valueObject instanceof Boolean || valueObject instanceof Character || valueObject instanceof String) {
            value = valueObject.toString();
        } else {
            try {
                value = this.objectMapper.writeValueAsString(valueObject);
            } catch (JsonProcessingException e) {
                value = valueObject.toString();
            }
        }

        this.elements.get(fieldName).setValue(value);
        return value;
    }

    private void hydrateFromRecord(Record record) {
        for (var recordComponent : record.getClass().getRecordComponents()) {
            if (this.elements.containsKey(recordComponent.getName())) {
                Object valueObject;
                try {
                    valueObject = recordComponent.getAccessor().invoke(record);
                } catch (IllegalAccessException | InvocationTargetException e) {
                    throw new RuntimeException(e);
                }
                this.hydrateElement(recordComponent.getName(), valueObject);
            }
        }
    }
}

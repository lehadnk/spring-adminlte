package adminlte.web_form.business.hydrator;

import adminlte.web_form.communication.form_elements.Input;
import adminlte.web_form.communication.form_elements.Localizable;
import adminlte.web_form.communication.form_elements.WebFormFieldElementInterface;
import adminlte.web_form.dto.FileData;
import adminlte.web_form.dto.LocalizedField;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.time.LocalDateTime;
import java.util.UUID;

public class ElementHydrator {
    final private ObjectMapper objectMapper;

    public ElementHydrator() {
        this.objectMapper = new ObjectMapper();
        this.objectMapper.findAndRegisterModules();
        this.objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
    }

    // @todo This method is total bs, marked to overhaul
    public Object hydrateFormElement(WebFormFieldElementInterface formElement, Object valueObject) {
        String value;

        if (valueObject == null) {
            value = null;
        } else if (valueObject instanceof String stringValue && stringValue.isEmpty()) {
            value = stringValue;
            // @todo What is this?
            if (formElement instanceof Input input) {
                if (input.getNullable()) {
                    value = null;
                }
            }
        } else if (valueObject instanceof LocalizedField fileData) {
            var input = (Localizable) formElement;
            assert input.getGlossaryKey().equals(fileData.getKey());
            var localizedFieldValue = fileData.getLocalization().toMap();
            input.setValue(localizedFieldValue);
            return localizedFieldValue;
        } else if (valueObject instanceof FileData fileData) {
            value = fileData.getFileUrl();
        } else if (valueObject instanceof Integer || valueObject instanceof Long || valueObject instanceof Double
                || valueObject instanceof Float || valueObject instanceof Boolean || valueObject instanceof Character
                || valueObject instanceof String) {
            value = valueObject.toString();
        } else if (valueObject instanceof LocalDateTime localDateTime) {
            value = localDateTime.toString();
        } else if (valueObject.getClass().isEnum()) {
            value = valueObject.toString();
        } else if (valueObject instanceof UUID uuid) {
            value = uuid.toString();
        } else {
            try {
                value = this.objectMapper.writeValueAsString(valueObject);
            } catch (JsonProcessingException e) {
                value = valueObject.toString();
            }
        }

        formElement.setValue(value);
        return value;
    }
}

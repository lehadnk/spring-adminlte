package adminlte.web_form.communication.validators;

import adminlte.web_form.dto.ValidationResult;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.lang.reflect.Field;
import java.util.ArrayList;

abstract public class AbstractJsonStructureValidator<TJsonStructure> extends AbstractFormValidator {
    public Class<TJsonStructure> jsonStructureClass;

    @Override
    public ValidationResult validate(String value) {
        TJsonStructure jsonObject;

        if (value == null) {
            return this.errorValidationResult("Must not be empty");
        }

        var objectMapper = new ObjectMapper();
        objectMapper.findAndRegisterModules();

        try {
            jsonObject = objectMapper.readValue(value, this.jsonStructureClass);
        } catch (JsonProcessingException e) {
            return this.errorValidationResult("Invalid JSON structure");
        }

        if (jsonObject == null) {
            return this.errorValidationResult("Invalid JSON structure");
        }

        try {
            Field[] fields = this.jsonStructureClass.getFields();
            ArrayList<String> missingFields = new ArrayList<>();
            for(Field field: fields) {
                var jsonFieldValue = field.get(jsonObject);
                if (jsonFieldValue == null) {
                    missingFields.add(field.getName());
                }
            }
            if (missingFields.size() > 0) {
                return this.errorValidationResult("Invalid JSON structure. Missing required fields: " + String.join(", ", missingFields));
            }
        } catch (IllegalAccessException ex) {
            return this.errorValidationResult("Invalid JSON structure");
        }

        return this.successValidationResult();
    }
}

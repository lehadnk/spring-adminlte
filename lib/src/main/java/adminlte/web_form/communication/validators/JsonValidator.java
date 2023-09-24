package adminlte.web_form.communication.validators;

import adminlte.web_form.dto.ValidationResult;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonFactoryBuilder;

import java.io.IOException;

public class JsonValidator extends AbstractFormValidator {
    private JsonFactory jsonFactory = new JsonFactory(new JsonFactoryBuilder().disable(JsonFactory.Feature.INTERN_FIELD_NAMES));

    public JsonValidator setJsonFactory(JsonFactory jsonFactory)
    {
        this.jsonFactory = jsonFactory;
        return this;
    }

    @Override
    public ValidationResult validate(Object value) {
        try(var parser = this.jsonFactory.createParser(value.toString())) {
            var token = parser.nextToken();
            while (token != null) token = parser.nextToken();
        } catch (IOException ex) {
            return this.errorValidationResult("Invalid JSON: " + ex.toString());
        }

        return this.successValidationResult();
    }
}

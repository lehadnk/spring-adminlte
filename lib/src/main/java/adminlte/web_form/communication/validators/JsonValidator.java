package adminlte.web_form.communication.validators;

import adminlte.web_form.dto.ValidationResult;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonFactoryBuilder;

import java.io.IOException;

public class JsonValidator extends AbstractFormValidator {
    private static final JsonFactory JSON_FACTORY = new JsonFactory(new JsonFactoryBuilder().disable(JsonFactory.Feature.INTERN_FIELD_NAMES));

    @Override
    public ValidationResult validate(String value) {
        try(var parser = JSON_FACTORY.createParser(value)) {
            var token = parser.nextToken();
            while (token != null) token = parser.nextToken();
        } catch (IOException ex) {
            return this.errorValidationResult("Invalid JSON: " + ex.toString());
        }

        return this.successValidationResult();
    }
}

package adminlte.web_form.communication.validators;

import adminlte.web_form.dto.ValidationResult;
import org.json.*;

public class JsonValidator extends AbstractFormValidator {
    @Override
    public ValidationResult validate(String value) {
        try {
            new JSONObject(value);
        } catch (JSONException ex) {
            // In case JSONArray is valid as well
            try {
                new JSONArray(value);
            } catch (JSONException ex1) {
                return this.errorValidationResult("Invalid JSON");
            }
        }

        return this.successValidationResult();
    }
}

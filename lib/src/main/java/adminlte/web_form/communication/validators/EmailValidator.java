package adminlte.web_form.communication.validators;

import adminlte.web_form.dto.ValidationResult;

public class EmailValidator extends AbstractFormValidator {
    @Override
    public ValidationResult validate(String value) {
        if (value == null) {
            return this.errorValidationResult("Email cannot be empty");
        }

        if (value.contains("@")) {
            return this.successValidationResult();
        }

        return this.errorValidationResult("Incorrect email address");
    }
}

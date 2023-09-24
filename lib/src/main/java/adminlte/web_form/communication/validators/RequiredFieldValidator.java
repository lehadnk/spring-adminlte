package adminlte.web_form.communication.validators;

import adminlte.web_form.dto.ValidationResult;

public class RequiredFieldValidator extends AbstractFormValidator {
    @Override
    public ValidationResult validate(Object value) {
        if (value == null) {
            return this.errorValidationResult("Field is required");
        }

        return this.successValidationResult();
    }
}

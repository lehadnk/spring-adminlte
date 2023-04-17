package adminlte.web_form.communication.validators;

import adminlte.web_form.dto.ValidationResult;

public class IntegerValidator extends AbstractFormValidator {
    @Override
    public ValidationResult validate(String value) {
        if (value == null) {
            return this.successValidationResult();
        }

        try {
            Integer.parseInt(value);
            return this.successValidationResult();
        } catch (NumberFormatException e) {
            return this.errorValidationResult("Incorrect integer");
        }
    }
}

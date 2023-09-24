package adminlte.web_form.communication.form.validator;

import adminlte.web_form.business.builder.ValidationResultFactory;
import adminlte.web_form.communication.validators.AbstractFormValidator;
import adminlte.web_form.dto.ValidationResult;

public class ContainsOneValidator extends AbstractFormValidator {

    @Override
    public ValidationResult validate(Object value) {
        if (value == null) {
            return ValidationResultFactory.error("Value is null");
        }

        if (value.toString().contains("1")) {
            return ValidationResultFactory.success();
        }

        return ValidationResultFactory.error("Value does not contain 1");
    }
}

package adminlte.web_form.communication.validators;

import adminlte.web_form.dto.ValidationResult;

public interface WebFormValidatorInterface<TValueType> {
    ValidationResult validate(Object value);
}

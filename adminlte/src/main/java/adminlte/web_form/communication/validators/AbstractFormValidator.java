package adminlte.web_form.communication.validators;

import adminlte.web_form.dto.ValidationResult;

abstract public class AbstractFormValidator<TValueType> implements WebFormValidatorInterface<TValueType> {
    protected ValidationResult successValidationResult()
    {
        var result = new ValidationResult();
        result.isValid = true;
        return result;
    }

    protected ValidationResult errorValidationResult(String errorMessage)
    {
        var result = new ValidationResult();
        result.isValid = false;
        result.errorMessage = errorMessage;
        return result;
    }
}

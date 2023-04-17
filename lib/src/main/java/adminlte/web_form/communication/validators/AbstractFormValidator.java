package adminlte.web_form.communication.validators;

import adminlte.web_form.dto.ValidationResult;

abstract public class AbstractFormValidator implements WebFormValidatorInterface {
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

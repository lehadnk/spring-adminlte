package adminlte.web_form.business.builder;

import adminlte.web_form.dto.ValidationResult;

public class ValidationResultFactory {
    public static ValidationResult error(String errorMessage) {
        var validationResult = new ValidationResult();
        validationResult.isValid = false;
        validationResult.errorMessage = errorMessage;
        return validationResult;
    }

    public static ValidationResult success()
    {
        var validationResult = new ValidationResult();
        validationResult.isValid = true;
        return validationResult;
    }
}

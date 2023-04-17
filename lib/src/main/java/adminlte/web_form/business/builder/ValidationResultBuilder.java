package adminlte.web_form.business.builder;

import adminlte.web_form.dto.ValidationResult;
import org.springframework.stereotype.Component;

@Component
public class ValidationResultBuilder {
    public ValidationResult buildValidationError(String errorMessage) {
        var validationResult = new ValidationResult();
        validationResult.isValid = false;
        validationResult.errorMessage = errorMessage;
        return validationResult;
    }
}

package adminlte.web_form.communication.validators;

import adminlte.web_form.dto.ValidationResult;

public class AudioFileValidator extends AbstractFormValidator {
    @Override
    public ValidationResult validate(String value) {
        if (value == null) {
            return this.successValidationResult();
        }

        if (value.endsWith(".mp3")) {
            return this.successValidationResult();
        }

        return this.errorValidationResult("Incorrect audio format (allowed only .mp3)");
    }
}

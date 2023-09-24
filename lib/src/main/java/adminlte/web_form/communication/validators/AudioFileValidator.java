package adminlte.web_form.communication.validators;

import adminlte.web_form.dto.ValidationResult;
import ch.qos.logback.core.rolling.helper.FileNamePattern;

import java.nio.file.Files;
import java.util.List;

public class AudioFileValidator extends AbstractFormValidator<String> {
    public List<String> allowedFormats = List.of("mp3", "wav");

    public AudioFileValidator setAllowedFormats(List<String> formats)
    {
        this.allowedFormats = formats;
        return this;
    }

    @Override
    public ValidationResult validate(String value) {
        if (value == null) {
            return this.successValidationResult();
        }

        for (var extension : this.allowedFormats) {
            if (value.endsWith("." + extension)) {
                return this.successValidationResult();
            }
        }

        return this.errorValidationResult("Incorrect audio format (allowed only .mp3)");
    }
}

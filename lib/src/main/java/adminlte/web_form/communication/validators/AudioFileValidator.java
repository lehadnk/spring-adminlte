package adminlte.web_form.communication.validators;

import adminlte.web_form.dto.ValidationResult;
import ch.qos.logback.core.rolling.helper.FileNamePattern;

import java.nio.file.Files;
import java.util.List;

public class AudioFileValidator extends AbstractFormValidator {
    public List<String> allowedFormats = List.of("mp3", "wav");

    public AudioFileValidator setAllowedFormats(List<String> formats)
    {
        this.allowedFormats = formats;
        return this;
    }

    @Override
    public ValidationResult validate(Object value) {
        if (value == null) {
            return this.successValidationResult();
        }

        var fileName = value.toString();
        for (var extension : this.allowedFormats) {
            if (fileName.endsWith("." + extension)) {
                return this.successValidationResult();
            }
        }

        return this.errorValidationResult("Incorrect audio format (allowed only .mp3)");
    }
}

package adminlte.web_form.communication.form_elements;

import adminlte.web_form.communication.validators.WebFormValidatorInterface;
import adminlte.web_form.dto.ValidationResult;

import java.util.List;
import java.util.Map;

public interface WebFormElementInterface {
    WebFormElementInterface setValue(String value);

    String getTemplatePath();

    String getValue();

    List<ValidationResult> validate();

    List<ValidationResult> getValidationResults();

    Boolean isValid();

    WebFormElementInterface addValidator(WebFormValidatorInterface validator);

    Map<String, Object> getContextVariables();

}

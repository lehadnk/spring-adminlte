package adminlte.web_form.communication.form_elements;

import adminlte.web_form.communication.validators.WebFormValidatorInterface;
import adminlte.web_form.dto.ValidationResult;

import java.util.ArrayList;
import java.util.Map;

public interface WebFormElementInterface {
    WebFormElementInterface setValue(String value);

    String getTemplatePath();

    String getValue();

    ArrayList<ValidationResult> validate();

    ArrayList<ValidationResult> getValidationResults();

    Boolean isValid();

    WebFormElementInterface addValidator(WebFormValidatorInterface validator);

    String getLabel();

    WebFormElementInterface setLabel(String label);

    Map<String, Object> getContextVariables();

    WebFormElementInterface setRequired();

}

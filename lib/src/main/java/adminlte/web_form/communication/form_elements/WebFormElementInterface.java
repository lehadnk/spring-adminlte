package adminlte.web_form.communication.form_elements;

import adminlte.web_form.communication.validators.WebFormValidatorInterface;
import adminlte.web_form.dto.ValidationResult;

import java.util.List;
import java.util.Map;

public interface WebFormElementInterface<TValueType> {
    String getTemplatePath();

    WebFormElementInterface<TValueType> setValue(TValueType value);

    TValueType getValue();

    WebFormElementInterface<TValueType> addValidator(WebFormValidatorInterface<TValueType> validator);

    List<ValidationResult> validate();

    List<ValidationResult> getValidationResults();

    Boolean isValid();

    Map<String, Object> getContextVariables();

}

package adminlte.web_form.communication.form_elements;

import adminlte.web_form.communication.validators.WebFormValidatorInterface;
import adminlte.web_form.dto.ValidationResult;

import java.util.List;
import java.util.Map;

public interface WebFormFieldElementInterface<TValueType> extends WebFormElementInterface<TValueType> {
    String getLabel();
    WebFormFieldElementInterface setLabel(String label);
    WebFormElementInterface setRequired();
    WebFormElementInterface setRequired(boolean value);
    WebFormElementInterface setNullable();
    WebFormElementInterface setNullable(boolean value);
}

package adminlte.web_form.communication.form_elements;

public interface WebFormFieldElementInterface<TValueType> extends WebFormElementInterface<TValueType> {
    String getLabel();
    WebFormFieldElementInterface<TValueType> setLabel(String label);
    WebFormFieldElementInterface<TValueType> setRequired();
    WebFormFieldElementInterface<TValueType> setRequired(boolean value);
    WebFormFieldElementInterface<TValueType> setNullable();
    WebFormFieldElementInterface<TValueType> setNullable(boolean value);
    WebFormFieldElementInterface<TValueType> setId(String id);
}

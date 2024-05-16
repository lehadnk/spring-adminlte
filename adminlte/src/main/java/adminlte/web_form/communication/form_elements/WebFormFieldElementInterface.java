package adminlte.web_form.communication.form_elements;

public interface WebFormFieldElementInterface<TValueType> extends WebFormElementInterface<TValueType> {
    String getLabel();
    WebFormFieldElementInterface setLabel(String label);
    WebFormElementInterface setRequired();
    WebFormElementInterface setRequired(boolean value);
    WebFormElementInterface setNullable();
    WebFormElementInterface setNullable(boolean value);
}

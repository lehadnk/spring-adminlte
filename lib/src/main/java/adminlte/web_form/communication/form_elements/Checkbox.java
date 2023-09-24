package adminlte.web_form.communication.form_elements;

public class Checkbox extends AbstractFormFieldElement<Checkbox, String> {
    private final String templatePath = "web_form/form_elements/checkbox.html";

    @Override
    public String getTemplatePath() {
        return this.templatePath;
    }

    @Override
    public Checkbox setValue(String value)
    {
        if (value == null) {
            value = "false";
        }

        this.value = value;
        return this;
    }
}

package adminlte.web_form.communication.form_elements;

public class Submit extends AbstractFormElement<Submit> {
    private final String templatePath = "web_form/form_elements/submit.html";

    public Submit(String name)
    {
        this.value = name;
    }

    @Override
    public String getTemplatePath() {
        return this.templatePath;
    }
}

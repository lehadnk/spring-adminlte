package adminlte.web_form.communication.form_elements;

public class Hidden extends AbstractFormFieldElement<Hidden, String> {
    private final String templatePath = "web_form/form_elements/hidden.html";

    @Override
    public String getTemplatePath() {
        return this.templatePath;
    }
}

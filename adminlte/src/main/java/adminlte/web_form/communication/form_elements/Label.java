package adminlte.web_form.communication.form_elements;

public class Label extends AbstractFormFieldElement<Label, String> {
    private final String templatePath = "web_form/form_elements/label.html";

    @Override
    public String getTemplatePath() {
        return this.templatePath;
    }
}

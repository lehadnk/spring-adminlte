package adminlte.web_form.communication.form_elements;

public class Markdown extends AbstractFormFieldElement<Markdown> {
    private final String templatePath = "web_form/form_elements/markdown.html";

    @Override
    public String getTemplatePath() {
        return this.templatePath;
    }
}

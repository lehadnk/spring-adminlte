package adminlte.web_form.communication.form_elements;

public class WYSIWYGHtmlInput extends AbstractFormFieldElement<WYSIWYGHtmlInput> {
    private final String templatePath = "web_form/form_elements/wysiwyg_html_input.html";

    @Override
    public String getTemplatePath() {
        return this.templatePath;
    }
}

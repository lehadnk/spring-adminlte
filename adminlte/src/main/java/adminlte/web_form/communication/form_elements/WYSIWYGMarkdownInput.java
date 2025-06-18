package adminlte.web_form.communication.form_elements;

public class WYSIWYGMarkdownInput extends AbstractFormFieldElement<WYSIWYGMarkdownInput, String> {
    private final String templatePath = "web_form/form_elements/wysiwyg_markdown_input.html";

    @Override
    public String getTemplatePath() {
        return this.templatePath;
    }


    public WYSIWYGMarkdownInput() {
        id = "editor";
    }
}

package adminlte.web_form.communication.form_elements;

public class Json extends AbstractFormFieldElement<Json, String> {
    private final String templatePath = "web_form/form_elements/json.html";

    @Override
    public String getTemplatePath() {
        return this.templatePath;
    }
}

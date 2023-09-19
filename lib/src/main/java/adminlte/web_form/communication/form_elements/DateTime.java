package adminlte.web_form.communication.form_elements;

public class DateTime extends AbstractFormFieldElement<DateTime> {
    private final String templatePath = "web_form/form_elements/datetime.html";

    @Override
    public String getTemplatePath() {
        return this.templatePath;
    }
}

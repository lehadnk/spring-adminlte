package adminlte.web_form.communication.form_elements;

public class Audio extends AbstractFormElement {
    private String templatePath = "web_form/form_elements/audio.html";

    public Audio() {
    }

    @Override
    public String getTemplatePath() {
        return this.templatePath;
    }
}

package adminlte.web_form.communication.form_elements;

public class Video extends AbstractFormElement {
    private String templatePath = "web_form/form_elements/video.html";

    public Video() {
    }

    @Override
    public String getTemplatePath() {
        return this.templatePath;
    }
}

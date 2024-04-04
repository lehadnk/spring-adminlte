package adminlte.web_form.communication.form_elements;

import java.util.HashMap;

public class Video extends AbstractFormFieldElement<Video, String> {
    private final String templatePath = "web_form/form_elements/video.html";

    private Boolean hasUpdateUrlInput = false;

    public Video() {
    }

    public Video setHasUpdateUrlInput(Boolean hasUpdateUrlInput) {
        this.hasUpdateUrlInput = hasUpdateUrlInput;
        return this;
    }

    @Override
    public String getTemplatePath() {
        return this.templatePath;
    }

    public HashMap<String, Object> getContextVariables() {
        HashMap<String, Object> contextVariables = new HashMap<>();
        contextVariables.put("hasUpdateUrlInput", this.hasUpdateUrlInput);
        return contextVariables;
    }
}

package adminlte.web_form.communication.form_elements;

import java.util.HashMap;

public class Image extends AbstractFormElement {

    private String templatePath = "web_form/form_elements/image.html";
    private Integer maxWidth = 50;
    private Integer maxHeight = 50;
    private Boolean hasDeleteButton = true;

    public Image() {
    }

    public Image(Integer maxWidth, Integer maxHeight) {
        this.maxWidth = maxWidth;
        this.maxHeight = maxHeight;
    }

    @Override
    public String getTemplatePath() { return this.templatePath; }

    public Image setHasDeleteButton(Boolean delete) {
        this.hasDeleteButton = delete;
        return this;
    }

    public HashMap<String, Object> getContextVariables() {
        HashMap<String, Object> contextVariables = new HashMap<>();
        contextVariables.put("maxWidth", this.maxWidth);
        contextVariables.put("maxHeight", this.maxHeight);
        contextVariables.put("hasDelete", this.hasDeleteButton);
        return contextVariables;
    }
}

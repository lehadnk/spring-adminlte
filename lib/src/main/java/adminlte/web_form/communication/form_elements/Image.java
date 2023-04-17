package adminlte.web_form.communication.form_elements;

import java.util.HashMap;

public class Image extends AbstractFormElement {
    private String templatePath = "web_form/form_elements/image.html";
    private Integer maxWidth = 50;
    private Integer maxHeight = 50;

    public Image() {
    }

    public Image(Integer maxWidth, Integer maxHeight) {
        this.maxWidth = maxWidth;
        this.maxHeight = maxHeight;
    }

    @Override
    public String getTemplatePath() {
        return this.templatePath;
    }

    public HashMap<String, Object> getContextVariables() {
        HashMap<String, Object> contextVariables = new HashMap<>();
        contextVariables.put("maxWidth", this.maxWidth);
        contextVariables.put("maxHeight", this.maxHeight);
        return contextVariables;
    }
}

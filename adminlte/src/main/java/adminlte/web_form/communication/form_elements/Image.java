package adminlte.web_form.communication.form_elements;

import java.util.HashMap;
import java.util.Map;

public class Image extends AbstractFormFieldElement<Image, String> {
    private final String templatePath = "web_form/form_elements/image.html";
    private Integer maxWidth = 50;
    private Integer maxHeight = 50;
    private Boolean hasDeleteButton = true;
    private Boolean hasUpdateUrlInput = false;

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

    public Image setHasUpdateUrlInput(Boolean hasUpdateUrlInput) {
        this.hasUpdateUrlInput = hasUpdateUrlInput;
        return this;
    }

    public Map<String, Object> getContextVariables() {
        var contextVariables = new HashMap<String, Object>();
        contextVariables.put("maxWidth", this.maxWidth);
        contextVariables.put("maxHeight", this.maxHeight);
        contextVariables.put("hasDeleteButton", this.hasDeleteButton);
        contextVariables.put("hasUpdateUrlInput", this.hasUpdateUrlInput);
        return contextVariables;
    }
}

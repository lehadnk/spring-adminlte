package adminlte.web_form.communication.form_elements;

import java.util.HashMap;
import java.util.Map;


public class SubmitButton extends AbstractFormFieldElement<SubmitButton, String> {
    private final String templatePath = "web_form/form_elements/submit_button.html";

    private String cssClass = "btn-primary";
    private String text = "Submit [Inline]";
    private String name = "submit";

    public SubmitButton setCssClass(String cssClass) {
        this.cssClass = cssClass;
        return this;
    }

    public SubmitButton setText(String text) {
        this.text = text;
        return this;
    }

    public SubmitButton setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public String getTemplatePath() {
        return this.templatePath;
    }

    public Map<String, Object> getContextVariables() {
        var contextVariables = new HashMap<String, Object>();
        contextVariables.put("cssClass", this.cssClass);
        contextVariables.put("text", this.text);
        contextVariables.put("value", this.value);
        contextVariables.put("name", this.name);
        return contextVariables;
    }
}

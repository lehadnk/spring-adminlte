package adminlte.web_form.communication.form_elements;

import java.util.HashMap;

public class Submit extends AbstractFormElement<Submit> {
    private final String templatePath = "web_form/form_elements/submit.html";

    private String name = "submit";
    private final String text;

    public Submit(String text) {
        this.text = text;
    }

    public Submit setName(String name) {
        this.name = name;
        return this;
    }

    public String getName()
    {
        return this.name;
    }

    @Override
    public String getTemplatePath() { return this.templatePath; }

    public HashMap<String, Object> getContextVariables() {
        HashMap<String, Object> contextVariables = new HashMap<>();
        contextVariables.put("text", this.text);
        contextVariables.put("name", this.name);
        contextVariables.put("value", this.value);
        return contextVariables;
    }
}

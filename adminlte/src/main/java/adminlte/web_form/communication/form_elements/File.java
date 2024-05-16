package adminlte.web_form.communication.form_elements;

import java.util.HashMap;
import java.util.Map;

public class File extends AbstractFormFieldElement<File, String> {
    private final String templatePath = "web_form/form_elements/file.html";
    private String accept;
    private Boolean multiple = false;

    public File(String accept) {
        this.accept = accept;
    }

    @Override
    public String getTemplatePath() { return this.templatePath; }

    public File setMultiple(Boolean multiple) {
        this.multiple = multiple;
        return this;
    }

    public Map<String, Object> getContextVariables() {
        var contextVariables = new HashMap<String, Object>();
        contextVariables.put("accept", this.accept);
        contextVariables.put("multiple", this.multiple);
        return contextVariables;
    }
}

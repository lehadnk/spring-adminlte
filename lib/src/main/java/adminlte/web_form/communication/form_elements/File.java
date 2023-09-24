package adminlte.web_form.communication.form_elements;

import java.util.HashMap;

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

    public HashMap<String, Object> getContextVariables() {
        HashMap<String, Object> contextVariables = new HashMap<>();
        contextVariables.put("accept", this.accept);
        contextVariables.put("multiple", this.multiple);
        return contextVariables;
    }
}

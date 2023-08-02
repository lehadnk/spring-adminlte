package adminlte.web_form.communication.form_elements;

import java.util.HashMap;

public class File extends AbstractFormElement {

    private String templatePath = "web_form/form_elements/file.html";
    private String accept;

    public File(String accept) {
        this.accept = accept;
    }

    @Override
    public String getTemplatePath() { return this.templatePath; }

    public HashMap<String, Object> getContextVariables() {
        HashMap<String, Object> contextVariables = new HashMap<>();
        contextVariables.put("accept", this.accept);
        return contextVariables;
    }
}

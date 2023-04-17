package adminlte.web_form.communication.form_elements;

import java.util.Map;

public class Textarea extends AbstractFormElement {
    private String templatePath = "web_form/form_elements/textarea.html";
    private String textTransform = "";
    private Integer rowsCount = 10;

    public Textarea() {}

    public Textarea(Integer rowsCount) {
        this();
        this.rowsCount = rowsCount;
    }

    @Override
    public String getTemplatePath() {
        return this.templatePath;
    }

    public Textarea setTextTransform(String textTransform) {
        this.textTransform = textTransform;
        return this;
    }

    @Override
    public Map<String, Object> getContextVariables() {
        return Map.of(
            "textTransform", textTransform,
            "rowsCount", rowsCount
        );
    }
}

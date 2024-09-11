package adminlte.web_form.communication.form_elements;

import java.util.HashMap;
import java.util.Map;

public class Textarea extends AbstractFormFieldElement<Textarea, String> {

    private final String templatePath = "web_form/form_elements/textarea.html";
    private String textTransform = "";
    private Integer rowsCount = 10;

    public Textarea() {
    }

    public Textarea(Integer rowsCount) {
        this();
        this.rowsCount = rowsCount;
    }

    @Override
    public String getTemplatePath() { return this.templatePath; }

    public Textarea setTextTransform(String textTransform) {
        this.textTransform = textTransform;
        return this;
    }

    @Override
    public Map<String, Object> getContextVariables() {
        var context = new HashMap<String, Object>();
        context.put("textTransform", this.textTransform);
        context.put("rowsCount", this.rowsCount);
        context.put("required", this.required);
        context.put("id", this.id);

        return context;
    }
}

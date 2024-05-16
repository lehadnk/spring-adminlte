package adminlte.web_form.communication.form_elements;

import java.util.HashMap;
import java.util.Map;

public class Password extends AbstractFormFieldElement<Password, String> {
    private final String templatePath = "web_form/form_elements/password.html";
    private Boolean autocompleteCurrentPassword = false;
    private Boolean autocompleteNewPassword = false;

    @Override
    public String getTemplatePath() {
        return this.templatePath;
    }

    public Password setAutocompleteCurrentPassword(Boolean value)
    {
        this.autocompleteCurrentPassword = value;
        return this;
    }

    public Password setAutocompleteNewPassword(Boolean value)
    {
        this.autocompleteNewPassword = value;
        return this;
    }

    public Map<String, Object> getContextVariables() {
        var contextVariables = new HashMap<String, Object>();
        contextVariables.put("autocompleteCurrentPassword", this.autocompleteCurrentPassword);
        contextVariables.put("autocompleteNewPassword", this.autocompleteNewPassword);
        return contextVariables;
    }
}

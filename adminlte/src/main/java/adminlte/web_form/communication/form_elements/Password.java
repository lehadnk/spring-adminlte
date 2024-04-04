package adminlte.web_form.communication.form_elements;

import java.util.HashMap;

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

    public HashMap<String, Object> getContextVariables() {
        HashMap<String, Object> contextVariables = new HashMap<>();
        contextVariables.put("autocompleteCurrentPassword", this.autocompleteCurrentPassword);
        contextVariables.put("autocompleteNewPassword", this.autocompleteNewPassword);
        return contextVariables;
    }
}

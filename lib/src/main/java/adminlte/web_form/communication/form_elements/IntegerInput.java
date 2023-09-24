package adminlte.web_form.communication.form_elements;

import adminlte.web_form.communication.validators.IntegerValidator;

public class IntegerInput extends AbstractFormFieldElement<IntegerInput, String> {
    private final String templatePath = "web_form/form_elements/integer_input.html";

    @Override
    public String getTemplatePath() {
        return this.templatePath;
    }

    public IntegerInput() {
        this.addValidator(new IntegerValidator());
    }
}

package adminlte.web_form.communication.form_elements;

import adminlte.web_form.communication.validators.EmailValidator;

public class Email extends AbstractFormElement {
    private String templatePath = "web_form/form_elements/email.html";

    public Email()
    {
        this.addValidator(new EmailValidator());
    }

    @Override
    public String getTemplatePath() {
        return this.templatePath;
    }
}

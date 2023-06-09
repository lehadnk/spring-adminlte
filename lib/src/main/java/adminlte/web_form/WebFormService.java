package adminlte.web_form;

import adminlte.web_form.business.FormRenderer;
import adminlte.web_form.business.FormValidator;
import adminlte.web_form.business.builder.ValidationResultFactory;
import adminlte.web_form.communication.AbstractWebForm;
import adminlte.web_form.dto.ValidationResult;

public class WebFormService {
    private FormRenderer formRenderer;
    private FormValidator formValidator;

    public WebFormService(
            FormRenderer formRenderer,
            FormValidator formValidator
    ) {
        this.formRenderer = formRenderer;
        this.formValidator = formValidator;
    }

    public String renderForm(AbstractWebForm<?> form)
    {
        return this.formRenderer.render(form);
    }

    public Boolean isFormValid(AbstractWebForm<?> form) {
        return this.formValidator.isValid(form);
    }

    public ValidationResult buildValidationError(String errorMessage) {
        return ValidationResultFactory.error(errorMessage);
    }
}

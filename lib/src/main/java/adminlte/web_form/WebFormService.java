package adminlte.web_form;

import adminlte.web_form.business.FormRenderer;
import adminlte.web_form.business.FormValidator;
import adminlte.web_form.business.builder.ValidationResultBuilder;
import adminlte.web_form.communication.AbstractWebForm;
import adminlte.web_form.dto.ValidationResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public class WebFormService {
    private FormRenderer formRenderer;
    private ValidationResultBuilder validationResultBuilder;
    private FormValidator formValidator;

    public WebFormService(
            FormRenderer formRenderer,
            ValidationResultBuilder validationResultBuilder,
            FormValidator formValidator
    ) {
        this.formRenderer = formRenderer;
        this.validationResultBuilder = validationResultBuilder;
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
        return this.validationResultBuilder.buildValidationError(errorMessage);
    }
}

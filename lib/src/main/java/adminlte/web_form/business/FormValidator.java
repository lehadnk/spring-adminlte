package adminlte.web_form.business;

import adminlte.web_form.communication.AbstractWebForm;
import adminlte.web_form.communication.form_elements.WebFormElementInterface;

public class FormValidator {

    public Boolean isValid(AbstractWebForm<?> form)
    {
        if (!form.validationErrorMessages.isEmpty()) {
            return false;
        }

        var isValid = true;
        for (WebFormElementInterface formElement: form.elements.values()) {
            if (!formElement.isValid()) {
                // We don't do return here, so all fields are processed
                isValid = false;
            }
        }

        return isValid;
    }
}

package adminlte.web_form.business;

import adminlte.web_form.communication.dto.TestFormRequest;
import adminlte.web_form.communication.form.TestForm;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FormValidatorTest {
    @Test
    public void testIsValid() {
        var formValidator = new FormValidator();
        var form = new TestForm();

        var request = new TestFormRequest();
        request.json = "{\"test\": \"1\"}";
        form.hydrateFromRequest(request);

        assertEquals(true, formValidator.isValid(form));
    }
}

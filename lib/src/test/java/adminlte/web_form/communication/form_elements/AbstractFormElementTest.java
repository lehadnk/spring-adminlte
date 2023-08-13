package adminlte.web_form.communication.form_elements;

import adminlte.web_form.communication.dto.TestFormRequest;
import adminlte.web_form.communication.form.TestForm;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AbstractFormElementTest {
    @Test
    public void testIsValid()
    {
        var form = new TestForm();

        var request = new TestFormRequest();
        request.json = "{\"test\": \"1\"}";
        form.hydrateFromRequest(request);

        var field = form.elements.get("json");

        assertEquals(true, field.isValid());
    }
}

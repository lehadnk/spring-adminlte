package adminlte.web_form.communication.form;

import adminlte.web_form.communication.AbstractWebForm;
import adminlte.web_form.communication.dto.TestFormRequest;
import adminlte.web_form.communication.form.validator.ContainsOneValidator;
import adminlte.web_form.communication.form_elements.Json;

public class TestForm extends AbstractWebForm<TestFormRequest> {
    public TestForm()
    {
        this.elements.put("json", new Json().addValidator(new ContainsOneValidator()));
    }
}

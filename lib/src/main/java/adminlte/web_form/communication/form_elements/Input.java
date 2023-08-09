package adminlte.web_form.communication.form_elements;

import adminlte.web_form.communication.validators.IntegerValidator;
import adminlte.web_form.communication.validators.RequiredFieldValidator;

import java.util.Map;

public class Input extends AbstractFormElement<Input> {
    private final String templatePath = "web_form/form_elements/input.html";
    private String type = "text";

    public static Input numberInput(String label) {
        return (Input) new Input()
            .setType("number")
            .setLabel(label)
            .addValidator(new IntegerValidator());
    }

    public static Input textField(String label) {
        return (Input) new Input()
            .setType("text")
            .setLabel(label);
    }

    public static Input hiddenField() {
        return new Input()
            .setType("hidden");
    }

    public Input setType(String type) {
        this.type = type;
        return this;
    }

    public boolean getNullable() {
        return this.nullable;
    }

    @Override
    public String getTemplatePath() {
        return this.templatePath;
    }

    @Override
    public Map<String, Object> getContextVariables() {
        return Map.of(
            "required", this.required,
            "nullable", this.nullable,
            "type", this.type
        );
    }
}

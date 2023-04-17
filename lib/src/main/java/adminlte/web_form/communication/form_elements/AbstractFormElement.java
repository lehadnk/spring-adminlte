package adminlte.web_form.communication.form_elements;


import adminlte.web_form.communication.validators.WebFormValidatorInterface;
import adminlte.web_form.communication.validators.RequiredFieldValidator;
import adminlte.web_form.dto.ValidationResult;

import java.util.ArrayList;
import java.util.Map;

abstract public class AbstractFormElement implements WebFormElementInterface {
    public String label;
    public String value;

    protected ArrayList<WebFormValidatorInterface> validators = new ArrayList<>();
    private ArrayList<ValidationResult> validationResults = new ArrayList<>();
    private boolean isValid = false;
    private boolean wasValidated = false;
    private boolean required = false;

    abstract public String getTemplatePath();

    public AbstractFormElement setValue(String value) {
        this.value = value;
        return this;
    }

    public String getValue()
    {
        return this.value;
    }

    @Override
    public WebFormElementInterface addValidator(WebFormValidatorInterface validator) {
        this.validators.add(validator);
        return this;
    }

    public ArrayList<ValidationResult> validate()
    {
        this.validationResults = new ArrayList<>();
        for(WebFormValidatorInterface validator: this.validators) {
            this.validationResults.add(validator.validate(this.getValue()));
        }

        this.wasValidated = true;
        return this.validationResults;
    }

    public WebFormElementInterface addValidationResult(ValidationResult validationResult) {
        this.validationResults.add(validationResult);
        return this;
    }

    public ArrayList<ValidationResult> getValidationResults()
    {
        return this.validationResults;
    }

    public Boolean isValid()
    {
        if (!this.wasValidated) {
            this.validate();
        }

        for(ValidationResult validationResult: this.validationResults) {
            if (!validationResult.isValid) {
                return false;
            }
        }

        return true;
    }

    public String getLabel()
    {
        return this.label;
    }

    public WebFormElementInterface setLabel(String label)
    {
        this.label = label;
        return this;
    }

    public Map<String, Object> getContextVariables() {
        return null;
    }

    public WebFormElementInterface setRequired() {
        this.addValidator(new RequiredFieldValidator());
        this.required = true;
        return this;
    }
}

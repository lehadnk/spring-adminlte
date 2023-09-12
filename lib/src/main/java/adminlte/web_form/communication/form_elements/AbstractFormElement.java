package adminlte.web_form.communication.form_elements;


import adminlte.web_form.communication.validators.WebFormValidatorInterface;
import adminlte.web_form.communication.validators.RequiredFieldValidator;
import adminlte.web_form.dto.ValidationResult;

import java.util.ArrayList;
import java.util.Map;

public abstract class AbstractFormElement<T extends AbstractFormElement<T>> implements WebFormElementInterface {
    public String label;
    public String value;

    protected ArrayList<WebFormValidatorInterface> validators = new ArrayList<>();
    private ArrayList<ValidationResult> validationResults = new ArrayList<>();
    private boolean wasValidated = false;
    protected boolean required = false;
    protected boolean nullable = true;

    abstract public String getTemplatePath();

    public String getValue()
    {
        return this.value;
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

    public Map<String, Object> getContextVariables() {
        return null;
    }

    @SuppressWarnings("unchecked")
    protected T casted()
    {
        return (T) this;
    }

    public T addValidator(WebFormValidatorInterface validator) {
        this.validators.add(validator);
        return this.casted();
    }

    public T setValue(String value) {
        this.value = value;
        return this.casted();
    }

    public T addValidationResult(ValidationResult validationResult) {
        this.validationResults.add(validationResult);
        return this.casted();
    }

    public T setLabel(String label)
    {
        this.label = label;
        return this.casted();
    }

    public T setRequired() {
        this.addValidator(new RequiredFieldValidator());
        this.required = true;
        return this.casted();
    }

    public T setNullable(boolean value) {
        this.nullable = value;
        return this.casted();
    }
}

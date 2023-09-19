package adminlte.web_form.communication.form_elements;


import adminlte.web_form.communication.validators.WebFormValidatorInterface;
import adminlte.web_form.dto.ValidationResult;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public abstract class AbstractFormElement<T extends AbstractFormElement<T>> implements WebFormElementInterface {
    protected ArrayList<WebFormValidatorInterface> validators = new ArrayList<>();
    private ArrayList<ValidationResult> validationResults = new ArrayList<>();
    private boolean wasValidated = false;

    public String value;

    abstract public String getTemplatePath();

    public List<ValidationResult> validate()
    {
        this.validationResults = new ArrayList<>();
        for(WebFormValidatorInterface validator: this.validators) {
            this.validationResults.add(validator.validate(this.getValue()));
        }

        this.wasValidated = true;
        return this.validationResults;
    }

    public List<ValidationResult> getValidationResults()
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

    public T addValidationResult(ValidationResult validationResult) {
        this.validationResults.add(validationResult);
        return this.casted();
    }

    public String getValue()
    {
        return this.value;
    }

    public T setValue(String value) {
        this.value = value;
        return this.casted();
    }
}

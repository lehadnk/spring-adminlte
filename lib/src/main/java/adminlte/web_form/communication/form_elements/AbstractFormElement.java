package adminlte.web_form.communication.form_elements;


import adminlte.web_form.communication.validators.WebFormValidatorInterface;
import adminlte.web_form.dto.ValidationResult;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public abstract class AbstractFormElement<TSelf extends AbstractFormElement<TSelf, TValueType>, TValueType> implements WebFormElementInterface<TValueType> {
    protected ArrayList<WebFormValidatorInterface<TValueType>> validators = new ArrayList<>();
    private ArrayList<ValidationResult> validationResults = new ArrayList<>();
    private boolean wasValidated = false;

    public TValueType value;

    abstract public String getTemplatePath();

    public List<ValidationResult> validate()
    {
        this.validationResults = new ArrayList<>();
        for(WebFormValidatorInterface<TValueType> validator: this.validators) {
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
    protected TSelf casted()
    {
        return (TSelf) this;
    }

    public TSelf addValidator(WebFormValidatorInterface<TValueType> validator)
    {
        this.validators.add(validator);
        return this.casted();
    }

    public TSelf addValidationResult(ValidationResult validationResult) {
        this.validationResults.add(validationResult);
        return this.casted();
    }

    public TValueType getValue()
    {
        return this.value;
    }

    public TSelf setValue(TValueType value) {
        this.value = value;
        return this.casted();
    }
}

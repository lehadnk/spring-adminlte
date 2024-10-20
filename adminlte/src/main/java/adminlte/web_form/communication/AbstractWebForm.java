package adminlte.web_form.communication;

import adminlte.web_form.business.exceptions.NoElementException;
import adminlte.web_form.business.hydrator.ElementHydrator;
import adminlte.web_form.business.hydrator.FieldListProvider;
import adminlte.web_form.business.hydrator.ObjectToFormHydrator;
import adminlte.web_form.business.hydrator.RecordToFormHydrator;
import adminlte.web_form.communication.form_elements.Submit;
import adminlte.web_form.communication.form_elements.WebFormFieldElementInterface;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

abstract public class AbstractWebForm<TRequest> {
    public Map<String, WebFormFieldElementInterface<?>> elements = new LinkedHashMap<>();
    public List<Submit> submitButtons = new ArrayList<>();
    public String actionUrl;
    public String enctype = "application/x-www-form-urlencoded";
    public List<String> validationErrorMessages = new ArrayList<>();
    public boolean simpleLayout = false;

    public void setSimpleLayout() {
        this.simpleLayout = true;
    }

    public String getActionUrl() {
        return this.actionUrl;
    }

    public AbstractWebForm<TRequest> setActionUrl(String actionUrl) {
        this.actionUrl = actionUrl;
        return this;
    }

    public String getEnctype() {
        return this.enctype;
    }

    public void setEnctype(String enctype) {
        this.enctype = enctype;
    }

    public AbstractWebForm<TRequest> multipart() {
        this.setEnctype("multipart/form-data");
        return this;
    }

    protected void addElement(String name, WebFormFieldElementInterface<?> element) {
        this.elements.put(name, element);
    }

    protected void addSubmitButton(Submit submit) {
        this.submitButtons.add(submit);
    }

    public void hydrateFromRequest(TRequest dto) {
        if (dto instanceof Record record) {
            var hydrator = new RecordToFormHydrator(new ElementHydrator());
            hydrator.hydrateFormFromRecord(this, record);
        } else {
            var hydrator = new ObjectToFormHydrator<TRequest>(new FieldListProvider(), new ElementHydrator());
            hydrator.hydrateFromRequest(this, dto);
        }
    }

    public void hydrateElement(String name, Object value)
    {
        var element = this.elements.get(name);
        if (element == null) {
            throw new NoElementException();
        }

        var elementHydrator = new ElementHydrator();
        elementHydrator.hydrateFormElement(element, value);
    }

    private static List<Field> getAllFields(Class<?> type) {
        var provider = new FieldListProvider();
        return provider.getAllFields(type);
    }

    public void addValidationErrorMessage(String message)
    {
        this.validationErrorMessages.add(message);
    }
}

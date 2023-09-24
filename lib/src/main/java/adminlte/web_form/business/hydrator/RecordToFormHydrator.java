package adminlte.web_form.business.hydrator;

import adminlte.web_form.communication.AbstractWebForm;
import adminlte.web_form.communication.form_elements.WebFormFieldElementInterface;

import java.lang.reflect.InvocationTargetException;

public class RecordToFormHydrator {
    private final ElementHydrator elementHydrator;

    public RecordToFormHydrator(
            ElementHydrator elementHydrator
    ) {
        this.elementHydrator = elementHydrator;
    }

    public void hydrateFormFromRecord(AbstractWebForm<?> form, Record record) {
        for (var recordComponent : record.getClass().getRecordComponents()) {
            if (form.elements.containsKey(recordComponent.getName())) {
                Object valueObject;
                try {
                    valueObject = recordComponent.getAccessor().invoke(record);
                } catch (IllegalAccessException | InvocationTargetException e) {
                    throw new RuntimeException(e);
                }

                this.elementHydrator.hydrateElement(form.elements.get(recordComponent.getName()), valueObject);
            }
        }
    }
}

package adminlte.web_form.business.hydrator;

import adminlte.web_form.communication.AbstractWebForm;
import adminlte.web_form.communication.form_elements.Input;

public class ObjectToFormHydrator<TRequest> {
    private final FieldListProvider fieldListProvider;
    private final ElementHydrator elementHydrator;

    public ObjectToFormHydrator(
            FieldListProvider fieldListProvider,
            ElementHydrator elementHydrator
    ) {
        this.fieldListProvider = fieldListProvider;
        this.elementHydrator = elementHydrator;
    }

    public void hydrateFromRequest(AbstractWebForm<TRequest> form, TRequest dto) {
        try {
            for (var field : this.fieldListProvider.getAllFields(dto.getClass())) {
                if (form.elements.containsKey(field.getName())) {
                    var formElement = form.elements.get(field.getName());

                    field.setAccessible(true);
                    var value = this.elementHydrator.hydrateElement(formElement, field.get(dto));

                    //@todo handling nullable property - I have a sense that we're doing something wrong here
                    if (value == null && formElement instanceof Input input && input.getNullable()) {
                        field.set(dto, null);
                    }
                }
            }
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}

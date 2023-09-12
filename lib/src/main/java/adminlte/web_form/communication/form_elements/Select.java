package adminlte.web_form.communication.form_elements;

import java.util.*;
import java.util.function.Function;

public class Select extends AbstractFormElement<Select> {

    private String templatePath = "web_form/form_elements/select.html";

    final private Map<Object, String> options;
    private Boolean searchable = false;
    private Boolean disabled = false;
    private Boolean multiple = false;
    private Integer multipleSize = 0; // No effect with no multiple, infinite with multiple, set to limit

    public Select(Map<String, String> options) {
        this.options = new LinkedHashMap<>(options);
        this.nullable = true;
    }

    public static <T extends Enum<T>> Select ofEnum(Class<T> type) {
        return ofEnum(type, T::name, T::name);
    }

    public static <T extends Enum<T>> Select ofEnum(Class<T> type, Function<T, String> valueMapper, Function<T, String> nameMapper) {
        var map = new HashMap<String, String>();

        for (var enumConstant : type.getEnumConstants()) { map.put(valueMapper.apply(enumConstant), nameMapper.apply(enumConstant)); }
        return new Select(map);
    }

    @Override
    public String getTemplatePath() { return this.templatePath; }

    public Select addOption(Object key, String title) {
        this.options.put(key, title);
        return this;
    }

    public Select setSearchable(Boolean value) {
        this.searchable = value;
        return this;
    }

    public Select setDisabled(Boolean value) {
        this.disabled = value;
        return this;
    }

    public Select setMultiple(Boolean value) {
        this.multiple = value;
        return this;
    }

    public Select setMultipleSize(int size) {
        this.multipleSize = size;
        return this;
    }

    public HashMap<String, Object> getContextVariables() {
        HashMap<String, Object> contextVariables = new HashMap<>();
        contextVariables.put("options", this.options);
        contextVariables.put("nullable", this.nullable);
        contextVariables.put("searchable", this.searchable);
        contextVariables.put("disabled", this.disabled);
        contextVariables.put("multiple", this.multiple);
        contextVariables.put("multipleSize", this.multipleSize);
        return contextVariables;
    }
}

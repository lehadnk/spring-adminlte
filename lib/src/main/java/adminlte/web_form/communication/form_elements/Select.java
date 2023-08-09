package adminlte.web_form.communication.form_elements;


import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;

public class Select extends AbstractFormElement<Select> {
    private String templatePath = "web_form/form_elements/select.html";

    final private Map<Object, String> options;
    private Boolean nullable = true;
    private Boolean searchable = false;
    private Boolean disabled = false;

    public Select(Map<String, String> options) {
        this.options = new LinkedHashMap<>(options);
    }

    public static <T extends Enum<T>> Select ofEnum(Class<T> type) {
        return ofEnum(type, T::name, T::name);
    }

    public static <T extends Enum<T>> Select ofEnum(Class<T> type, Function<T, String> valueMapper, Function<T, String> nameMapper) {
        var map = new HashMap<String, String>();
        for (var enumConstant : type.getEnumConstants()) {
            map.put(valueMapper.apply(enumConstant), nameMapper.apply(enumConstant));
        }
        return new Select(map);
    }

    @Override
    public String getTemplatePath() {
        return this.templatePath;
    }

    public Select addOption(Object key, String title) {
        this.options.put(key, title);
        return this;
    }

    public Select setNullable(Boolean value) {
        this.nullable = value;
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

    public HashMap<String, Object> getContextVariables() {
        HashMap<String, Object> contextVariables = new HashMap<>();
        contextVariables.put("options", this.options);
        contextVariables.put("nullable", this.nullable);
        contextVariables.put("searchable", this.searchable);
        contextVariables.put("disabled", this.disabled);
        return contextVariables;
    }
}

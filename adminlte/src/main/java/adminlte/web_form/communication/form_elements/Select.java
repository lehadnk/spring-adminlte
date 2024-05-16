package adminlte.web_form.communication.form_elements;

import java.util.*;
import java.util.function.Function;

public class Select extends AbstractFormFieldElement<Select, String> {

    private String templatePath = "web_form/form_elements/select.html";

    final private Map<Object, String> options;
    private Boolean searchable = false;
    private Boolean disabled = false;

    public Select(Map<String, String> options)
    {
        this.options = new LinkedHashMap<>(options);
    }

    public static <T extends Enum<T>> Select ofEnum(Class<T> type)
    {
        return ofEnum(type, T::name, T::name);
    }

    public static <T extends Enum<T>> Select ofEnum(Class<T> type, Function<T, String> valueMapper, Function<T, String> nameMapper)
    {
        var map = new HashMap<String, String>();

        for (var enumConstant : type.getEnumConstants()) { map.put(valueMapper.apply(enumConstant), nameMapper.apply(enumConstant)); }
        return new Select(map);
    }

    @Override
    public String getTemplatePath()
    {
        return this.templatePath;
    }

    public Select addOption(Object key, String title)
    {
        this.options.put(key, title);
        return this;
    }

    public Select setSearchable(Boolean value)
    {
        this.searchable = value;
        return this;
    }

    public Select setDisabled(Boolean value)
    {
        this.disabled = value;
        return this;
    }

    public Map<String, Object> getContextVariables()
    {
        var contextVariables = new HashMap<String, Object>();
        contextVariables.put("options", this.options);
        contextVariables.put("nullable", this.nullable);
        contextVariables.put("searchable", this.searchable);
        contextVariables.put("disabled", this.disabled);
        contextVariables.put("value", this.value);

        return contextVariables;
    }
}

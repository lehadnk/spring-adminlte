package adminlte.web_form.communication.form_elements;

import java.util.HashMap;
import java.util.Map;

public class Submit {
    private String name = "submit";
    private String value;
    private Integer length = 3;

    private final String text;

    public Submit(String text)
    {
        this.text = text;
    }

    public String getText()
    {
        return this.text;
    }

    public Submit setName(String name)
    {
        this.name = name;
        return this;
    }

    public String getName()
    {
        return this.name;
    }

    public Submit setValue(String value)
    {
        this.value = value;
        return this;
    }

    public String getValue()
    {
        return this.value;
    }

    public Submit setLength(Integer length)
    {
        this.length = length;
        return this;
    }

    public Integer getLength()
    {
        return this.length;
    }

    public Map<String, Object> getContextVariables()
    {
        var contextVariables = new HashMap<String, Object>();
        contextVariables.put("text", this.text);
        contextVariables.put("name", this.name);
        contextVariables.put("value", this.value);
        return contextVariables;
    }
}

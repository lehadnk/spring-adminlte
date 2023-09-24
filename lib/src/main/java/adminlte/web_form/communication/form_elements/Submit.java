package adminlte.web_form.communication.form_elements;

import java.util.HashMap;

public class Submit {
    private String name = "submit";
    private String value;

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

    public HashMap<String, Object> getContextVariables()
    {
        HashMap<String, Object> contextVariables = new HashMap<>();
        contextVariables.put("text", this.text);
        contextVariables.put("name", this.name);
        contextVariables.put("value", this.value);
        return contextVariables;
    }
}

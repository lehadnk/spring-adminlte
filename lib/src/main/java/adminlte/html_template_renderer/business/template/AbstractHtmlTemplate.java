package adminlte.html_template_renderer.business.template;

import org.thymeleaf.context.Context;

import java.util.Map;

abstract public class AbstractHtmlTemplate {
    public Context context = new Context();

    abstract public String getTemplatePath();

    abstract public AbstractHtmlLayout getLayoutTemplate();

    public Context getContext()
    {
        return this.context;
    }

    public void updateContext(Map<String, Object> contextVariables) {
        if (contextVariables == null) {
            return;
        }

        for (var entry : contextVariables.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            this.context.setVariable(key, value);
        }
    }
}

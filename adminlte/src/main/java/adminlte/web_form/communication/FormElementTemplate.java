package adminlte.web_form.communication;

import adminlte.html_template_renderer.business.template.AbstractHtmlLayout;
import adminlte.html_template_renderer.business.template.AbstractHtmlTemplate;

import java.util.ArrayList;
import java.util.List;

public class FormElementTemplate extends AbstractHtmlTemplate {
    private String templatePath;

    public FormElementTemplate(
            String name,
            String label,
            Object value,
            List<String> validationErrors,
            String templatePath
    ) {
        this.context.setVariable("name", name);
        this.context.setVariable("label", label);
        this.context.setVariable("value", value);
        this.context.setVariable("validationErrors", validationErrors);
        this.templatePath = templatePath;
    }

    @Override
    public String getTemplatePath()
    {
        return this.templatePath;
    }

    @Override
    public AbstractHtmlLayout getLayoutTemplate()
    {
        return null;
    }
}

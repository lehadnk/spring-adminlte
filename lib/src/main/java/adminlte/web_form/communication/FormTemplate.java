package adminlte.web_form.communication;

import adminlte.html_template_renderer.business.template.AbstractHtmlLayout;
import adminlte.html_template_renderer.business.template.AbstractHtmlTemplate;

import java.util.List;

public class FormTemplate extends AbstractHtmlTemplate {
    private String templatePath = "web_form/form.html";

    public FormTemplate(
            String action,
            String enctype,
            String contents,
            List<String> validationErrors
    ) {
        this.context.setVariable("action", action);
        this.context.setVariable("enctype", enctype);
        this.context.setVariable("contents", contents);
        this.context.setVariable("validationErrors", validationErrors);
    }

    @Override
    public String getTemplatePath() {
        return this.templatePath;
    }

    @Override
    public AbstractHtmlLayout getLayoutTemplate() {
        return null;
    }
}

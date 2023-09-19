package adminlte.web_form.communication;

import adminlte.html_template_renderer.business.template.AbstractHtmlLayout;
import adminlte.html_template_renderer.business.template.AbstractHtmlTemplate;

import java.util.List;

public class FormTemplate extends AbstractHtmlTemplate {
    private String templatePath = "web_form/form_card.html";

    public FormTemplate(
            String action,
            String enctype,
            String contents,
            List<String> validationErrors,
            boolean simpleLayout
    ) {
        this.context.setVariable("action", action);
        this.context.setVariable("enctype", enctype);
        this.context.setVariable("contents", contents);
        this.context.setVariable("validationErrors", validationErrors);
        this.templatePath = simpleLayout ? "web_form/form_simple.html" : "web_form/form_card.html";
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

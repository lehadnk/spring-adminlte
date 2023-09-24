package adminlte.web_form.communication;

import adminlte.html_template_renderer.business.template.AbstractHtmlLayout;
import adminlte.html_template_renderer.business.template.AbstractHtmlTemplate;
import adminlte.web_form.communication.form_elements.Submit;

import java.util.List;

public class SubmitButtonsTemplate extends AbstractHtmlTemplate {
    private final String templatePath = "web_form/submit_buttons.html";

    public SubmitButtonsTemplate(
            List<Submit> submitButtonsList
    ) {
        this.context.setVariable("submitButtons", submitButtonsList);
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

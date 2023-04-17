package adminlte.html_controller.communication.http.layout.general;

import adminlte.html_template_renderer.business.template.AbstractHtmlLayout;
import adminlte.html_template_renderer.business.template.AbstractHtmlTemplate;

abstract public class AbstractGeneralLayoutTemplate extends AbstractHtmlTemplate {
    private GeneralLayout layout;

    public AbstractGeneralLayoutTemplate(GeneralLayout layout)
    {
        this.layout = layout;
    }

    @Override
    public AbstractHtmlLayout getLayoutTemplate() {
        return this.layout;
    }
}

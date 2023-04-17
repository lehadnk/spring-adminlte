package adminlte.html_controller.communication.http.layout.authorized_admin;

import adminlte.html_template_renderer.business.template.AbstractHtmlLayout;
import adminlte.html_template_renderer.business.template.AbstractHtmlTemplate;

abstract public class AbstractAuthorizedAdminLayoutTemplate extends AbstractHtmlTemplate {
    private AuthorizedAdminLayout layout;

    public AbstractAuthorizedAdminLayoutTemplate(AuthorizedAdminLayout layout)
    {
        this.layout = layout;
    }

    @Override
    public AbstractHtmlLayout getLayoutTemplate() {
        return this.layout;
    }
}

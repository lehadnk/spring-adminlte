package adminlte.html_controller.communication.http.layout.authorized_admin;

import adminlte.html_template_renderer.business.template.AbstractHtmlLayout;
import org.springframework.stereotype.Component;

@Component
public class AuthorizedAdminLayout extends AbstractHtmlLayout {
    final private String templatePath = "html_controller/layout/authorized_admin.html";

    public AuthorizedAdminLayout(String pageTitle, String navigationMenuContents)
    {
        this.context.setVariable("pageTitle", pageTitle);
        this.context.setVariable("navigationMenu", navigationMenuContents);
    }

    @Override
    public String getTemplatePath() {
        return this.templatePath;
    }
}

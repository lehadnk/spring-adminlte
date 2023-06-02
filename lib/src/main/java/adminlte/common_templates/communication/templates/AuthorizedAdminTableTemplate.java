package adminlte.common_templates.communication.templates;

import adminlte.html_controller.communication.http.layout.authorized_admin.AbstractAuthorizedAdminLayoutTemplate;
import adminlte.html_controller.communication.http.layout.authorized_admin.AuthorizedAdminLayout;
import adminlte.ui.business.HrefButton;

import java.util.List;

public class AuthorizedAdminTableTemplate extends AbstractAuthorizedAdminLayoutTemplate {
    private String templatePath = "common_templates/authorized_admin_table.html";

    public AuthorizedAdminTableTemplate(
            AuthorizedAdminLayout layout,
            String tableContents
    ) {
        super(layout);
        this.context.setVariable("tableContents", tableContents);
        this.context.setVariable("buttonsOverTable", null);
    }

    public AuthorizedAdminTableTemplate(
            AuthorizedAdminLayout layout,
            String tableContents,
            List<HrefButton> buttonsOverTable
    ) {
        super(layout);
        this.context.setVariable("tableContents", tableContents);
        this.context.setVariable("buttonsOverTable", buttonsOverTable);
    }

    @Override
    public String getTemplatePath() {
        return this.templatePath;
    }
}

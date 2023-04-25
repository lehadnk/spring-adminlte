package adminlte.html_controller.communication.http.layout.authorized_admin;

import adminlte.flash_message.dto.FlashMessageData;
import adminlte.html_template_renderer.business.template.AbstractHtmlLayout;
import org.springframework.stereotype.Component;

public class AuthorizedAdminLayout extends AbstractHtmlLayout {
    final private String templatePath = "html_controller/layout/authorized_admin.html";

    public AuthorizedAdminLayout(String pageTitle, String navigationMenuContents, FlashMessageData flashMessageData)
    {
        this.context.setVariable("pageTitle", pageTitle);
        this.context.setVariable("navigationMenu", navigationMenuContents);
        this.context.setVariable("successFlashMessage", flashMessageData.successMessage);
        this.context.setVariable("errorFlashMessage", flashMessageData.errorMessage);
    }

    @Override
    public String getTemplatePath() {
        return this.templatePath;
    }
}

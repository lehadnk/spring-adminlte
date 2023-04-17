package adminlte.html_controller.communication.http.layout;

import adminlte.html_controller.communication.http.layout.authorized_admin.AuthorizedAdminLayout;
import adminlte.html_controller.communication.http.layout.general.GeneralLayout;
import adminlte.navigation_menu.NavigationMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * This class hides the rest of HtmlControllerFactory methods, so only layout creation is available on controller level
 */
public class LayoutFactory {
    private final NavigationMenuService navigationMenuService;

    public LayoutFactory(
            NavigationMenuService navigationMenuService
    ) {
        this.navigationMenuService = navigationMenuService;
    }

    public GeneralLayout createGeneralLayout()
    {
        return new GeneralLayout();
    }

    public AuthorizedAdminLayout createAuthorizedAdminLayout(String pageTitle)
    {
        return new AuthorizedAdminLayout(pageTitle, this.navigationMenuService.renderNavigationMenu());
    }
}

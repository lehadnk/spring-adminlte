package adminlte.html_controller.communication.http.layout;

import adminlte.flash_message.FlashMessageService;
import adminlte.html_controller.HtmlControllerConfig;
import adminlte.html_controller.communication.http.layout.authorized_admin.AuthorizedAdminLayout;
import adminlte.html_controller.communication.http.layout.general.GeneralLayout;
import adminlte.i18n.I18nService;
import adminlte.navigation_menu.NavigationMenuService;

/**
 * This class hides the rest of HtmlControllerFactory methods, so only layout creation is available on controller level
 */
public class LayoutFactory {
    private final NavigationMenuService navigationMenuService;
    private final FlashMessageService flashMessageService;
    private final I18nService i18nService;
    private final HtmlControllerConfig htmlControllerConfig;

    public LayoutFactory(
            NavigationMenuService navigationMenuService,
            FlashMessageService flashMessageService,
            I18nService i18nService,
            HtmlControllerConfig htmlControllerConfig
    ) {
        this.navigationMenuService = navigationMenuService;
        this.flashMessageService = flashMessageService;
        this.i18nService = i18nService;
        this.htmlControllerConfig = htmlControllerConfig;
    }

    public GeneralLayout createGeneralLayout()
    {
        return new GeneralLayout();
    }

    public AuthorizedAdminLayout createAuthorizedAdminLayout(String pageTitle)
    {
        return new AuthorizedAdminLayout(
                pageTitle,
                this.htmlControllerConfig.navigationMenuTitle,
                this.navigationMenuService.renderNavigationMenu(),
                this.i18nService.formatString("notification-success"),
                this.i18nService.formatString("notification-error"),
                this.flashMessageService.getFlashMessageData()
        );
    }
}

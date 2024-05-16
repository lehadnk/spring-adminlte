package adminlte.navigation_menu;

import adminlte.navigation_menu.business.MenuRenderer;
import adminlte.navigation_menu.business.NavigationMenuBuilder;
import adminlte.navigation_menu.communication.AbstractMenu;
import adminlte.navigation_menu.communication.navigation_menu.NavigationMenu;

public class NavigationMenuService {
    private MenuRenderer menuRenderer;
    private NavigationMenuBuilder navigationMenuBuilder;

    public NavigationMenuService(
            MenuRenderer menuRenderer,
            NavigationMenuBuilder navigationMenuBuilder
    ) {
        this.menuRenderer = menuRenderer;
        this.navigationMenuBuilder = navigationMenuBuilder;
    }

    public String renderMenu(AbstractMenu menu)
    {
        return this.menuRenderer.render(menu);
    }

    public NavigationMenu buildNavigationMenu() {
        return this.navigationMenuBuilder.buildMenu();
    }

    public String renderNavigationMenu() {
        return this.renderMenu(this.buildNavigationMenu());
    }
}

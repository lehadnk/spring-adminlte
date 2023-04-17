package adminlte.navigation_menu.business;

import adminlte.navigation_menu.NavigationMenuDependencyProviderInterface;
import adminlte.navigation_menu.communication.navigation_menu.NavigationMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

public class NavigationMenuBuilder {
    final private NavigationMenuDependencyProviderInterface navigationMenuDependencyProvider;

    public NavigationMenuBuilder(NavigationMenuDependencyProviderInterface navigationMenuDependencyProvider) {
        this.navigationMenuDependencyProvider = navigationMenuDependencyProvider;
    }

    public NavigationMenu buildMenu() {
        var menu = new NavigationMenu();

        var menuItemsProviders = this.navigationMenuDependencyProvider.getMenuItemProviders();

        for (var menuItemsProvider : menuItemsProviders) {
            var menuItems = menuItemsProvider.getMenuItems();
            for (var menuItem : menuItems) {
                menu.addMenuItem(menuItem);
            }
        }

        return menu;
    }
}

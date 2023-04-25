package adminlte.navigation_menu;

import adminlte.navigation_menu.communication.MenuItemsProviderInterface;

import java.util.List;

public class NavigationMenuDependencyProvider implements NavigationMenuDependencyProviderInterface {
    private final List<MenuItemsProviderInterface> menuItemsProviders;

    public NavigationMenuDependencyProvider(
            List<MenuItemsProviderInterface> menuItemsProviders
    ) {
        this.menuItemsProviders = menuItemsProviders;
    }

    @Override
    public List<MenuItemsProviderInterface> getMenuItemProviders() {
        return this.menuItemsProviders;
    }
}

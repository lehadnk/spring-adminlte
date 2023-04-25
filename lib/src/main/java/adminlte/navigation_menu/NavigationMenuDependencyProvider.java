package adminlte.navigation_menu;

import adminlte.navigation_menu.communication.AbstractMenuItemsProviderInterface;

import java.util.List;

public class NavigationMenuDependencyProvider implements NavigationMenuDependencyProviderInterface {
    private final List<AbstractMenuItemsProviderInterface> menuItemsProviders;

    public NavigationMenuDependencyProvider(
            List<AbstractMenuItemsProviderInterface> menuItemsProviders
    ) {
        this.menuItemsProviders = menuItemsProviders;
    }

    @Override
    public List<AbstractMenuItemsProviderInterface> getMenuItemProviders() {
        return this.menuItemsProviders;
    }
}

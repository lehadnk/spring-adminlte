package adminlte.navigation_menu;

import adminlte.navigation_menu.communication.AbstractMenuItemsProviderInterface;

import java.util.List;

public interface NavigationMenuDependencyProviderInterface {
    List<AbstractMenuItemsProviderInterface> getMenuItemProviders();
}

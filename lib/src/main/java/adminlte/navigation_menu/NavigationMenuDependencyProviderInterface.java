package adminlte.navigation_menu;

import adminlte.navigation_menu.communication.MenuItemsProviderInterface;

import java.util.List;

public interface NavigationMenuDependencyProviderInterface {
    List<MenuItemsProviderInterface> getMenuItemProviders();
}

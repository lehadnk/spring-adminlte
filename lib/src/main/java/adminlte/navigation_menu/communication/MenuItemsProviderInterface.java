package adminlte.navigation_menu.communication;

import adminlte.navigation_menu.communication.menu_item.MenuItemInterface;

import java.util.List;

public interface MenuItemsProviderInterface {
    List<MenuItemInterface> getMenuItems();
}

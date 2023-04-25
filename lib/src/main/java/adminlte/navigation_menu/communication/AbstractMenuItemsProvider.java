package adminlte.navigation_menu.communication;

import adminlte.navigation_menu.communication.menu_item.MenuItemInterface;

import java.util.ArrayList;

abstract public class AbstractMenuItemsProvider {
    abstract public ArrayList<MenuItemInterface> getMenuItems();
}

package adminlte.navigation_menu.communication;

import adminlte.navigation_menu.communication.menu_item.IMenuItem;

import java.util.ArrayList;

abstract public class AbstractMenuItemsProvider {
    abstract public ArrayList<IMenuItem> getMenuItems();
}

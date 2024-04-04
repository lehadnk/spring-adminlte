package adminlte.navigation_menu.communication;

import adminlte.navigation_menu.communication.menu_item.MenuItemInterface;

import java.util.ArrayList;

abstract public class AbstractMenu {
    public ArrayList<MenuItemInterface> menuItems = new ArrayList<>();

    public AbstractMenu() {
        this.buildMenu();
    }

    protected void buildMenu() {

    }

    public void addMenuItem(MenuItemInterface menuItem) {
        this.menuItems.add(menuItem);
    }
}

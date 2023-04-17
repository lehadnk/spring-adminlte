package adminlte.navigation_menu.communication;

import adminlte.navigation_menu.communication.menu_item.IMenuItem;

import java.util.ArrayList;

abstract public class AbstractMenu {
    public ArrayList<IMenuItem> menuItems = new ArrayList<>();

    public AbstractMenu() {
        this.buildMenu();
    }

    protected void buildMenu() {

    }

    public void addMenuItem(IMenuItem menuItem) {
        this.menuItems.add(menuItem);
    }
}

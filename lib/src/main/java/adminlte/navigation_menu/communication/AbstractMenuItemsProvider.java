package adminlte.navigation_menu.communication;

import adminlte.navigation_menu.communication.menu_item.MenuItemInterface;

import java.util.ArrayList;

/**
 * @deprecated Use {@link adminlte.navigation_menu.communication.AbstractMenuItemsProviderInterface} implementations instead.
 */
@Deprecated
abstract public class AbstractMenuItemsProvider implements AbstractMenuItemsProviderInterface {
    abstract public ArrayList<MenuItemInterface> getMenuItems();
}

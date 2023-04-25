package adminlte.navigation_menu.communication;

import adminlte.navigation_menu.communication.menu_item.MenuItemInterface;

import java.util.ArrayList;

/**
 * @deprecated Use {@link MenuItemsProviderInterface} implementations instead.
 */
@Deprecated
abstract public class AbstractMenuItemsProvider implements MenuItemsProviderInterface {
    abstract public ArrayList<MenuItemInterface> getMenuItems();
}

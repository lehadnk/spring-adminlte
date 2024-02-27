package adminlte.navigation_menu.communication.menu_item;

public interface MenuItemInterface {
    String getTemplatePath();

    String getTitle();

    MenuItemInterface setTitle(String title);

    String getUrl();

    MenuItemInterface setUrl(String url);
}

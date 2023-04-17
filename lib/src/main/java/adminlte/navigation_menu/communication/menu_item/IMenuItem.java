package adminlte.navigation_menu.communication.menu_item;

public interface IMenuItem {
    String getTemplatePath();

    String getTitle();

    IMenuItem setTitle(String title);

    String getUrl();

    IMenuItem setUrl(String url);
}

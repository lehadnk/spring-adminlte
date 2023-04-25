package adminlte.navigation_menu.communication.menu_item;

abstract public class AbstractMenuItemInterface implements MenuItemInterface {
    private String templatePath = "navigation_menu/menu_item/menu_item.html";
    public String title;
    public String url;

    public String getTemplatePath() {
        return this.templatePath;
    }

    public String getTitle() {
        return this.title;
    }

    public MenuItemInterface setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getUrl() {
        return this.url;
    }

    public MenuItemInterface setUrl(String url) {
        this.url = url;
        return this;
    }
}

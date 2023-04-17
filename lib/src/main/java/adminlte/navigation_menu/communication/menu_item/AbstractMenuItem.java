package adminlte.navigation_menu.communication.menu_item;

abstract public class AbstractMenuItem implements IMenuItem {
    private String templatePath = "navigation_menu/menu_item/menu_item.html";
    public String title;
    public String url;

    public String getTemplatePath() {
        return this.templatePath;
    }

    public String getTitle() {
        return this.title;
    }

    public IMenuItem setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getUrl() {
        return this.url;
    }

    public IMenuItem setUrl(String url) {
        this.url = url;
        return this;
    }
}

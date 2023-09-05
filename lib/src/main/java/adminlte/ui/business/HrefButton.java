package adminlte.ui.business;

public class HrefButton {
    public final String title;
    public final String url;
    public String cssClass = "btn-secondary";

    public HrefButton(String title, String url)
    {
        this.title = title;
        this.url = url;
    }

    public HrefButton setClass(String className)
    {
        this.cssClass = className;
        return this;
    }
}

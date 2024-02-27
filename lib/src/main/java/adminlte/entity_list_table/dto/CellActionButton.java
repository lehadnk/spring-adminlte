package adminlte.entity_list_table.dto;

public class CellActionButton {
    public String url;
    public String name;
    public String cssClass;
    public String method;

    public CellActionButton(String url, String name, String cssClass, String method)
    {
        this.url = url;
        this.name = name;
        this.cssClass = cssClass;
        this.method = method;
    }
}

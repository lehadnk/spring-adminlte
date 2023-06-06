package adminlte.entity_list_table.communication.http.tables.columns;

import java.util.List;

public class ActionButton {
    public final String text;
    public final String url;
    public final List<String> identifierFields;
    public final String cssClass;
    public final String method;

    public ActionButton(String text, String url, String identifierField, String cssClass) {
        this(text, url, List.of(identifierField), cssClass, "get");
    }

    public ActionButton(String text, String url, String identifierField) {
        this(text, url, List.of(identifierField), "btn-default", "get");
    }

    public ActionButton(String text, String url, List<String> identifierFields, String cssClass, String method) {
        this.text = text;
        this.url = url;
        this.identifierFields = identifierFields;
        this.cssClass = cssClass;
        this.method = method;
    }
}

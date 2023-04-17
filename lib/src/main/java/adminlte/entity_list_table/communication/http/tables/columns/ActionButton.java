package adminlte.entity_list_table.communication.http.tables.columns;

import java.util.List;

public class ActionButton {
    public final String text;
    public final String url;
    public final List<String> identifierFields;
    public final String cssClass;

    public ActionButton(String text, String url, String identifierField, String cssClass) {
        this(text, url, List.of(identifierField), cssClass);
    }

    public ActionButton(String text, String url, String identifierField) {
        this(text, url, List.of(identifierField), "btn-default");
    }

    public ActionButton(String text, String url, List<String> identifierFields, String cssClass) {
        this.text = text;
        this.url = url;
        this.identifierFields = identifierFields;
        this.cssClass = cssClass;
    }
}

package adminlte.entity_list_table.communication.http.tables.columns;

public class UrlColumn extends TextColumn {
    private final String templatePath = "entity_list_table/columns/url_column.html";

    public UrlColumn(String fieldName) {
        super(fieldName);
    }

    @Override
    public String getTemplatePath() {
        return this.templatePath;
    }
}

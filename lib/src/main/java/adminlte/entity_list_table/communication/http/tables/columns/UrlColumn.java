package adminlte.entity_list_table.communication.http.tables.columns;

import org.thymeleaf.context.Context;

public class UrlColumn extends TextColumn {

    private final String templatePath = "entity_list_table/columns/url_column.html";
    private String urlText;

    public UrlColumn(String fieldName) {
        super(fieldName);
    }

    @Override
    public String getTemplatePath() { return this.templatePath; }

    public UrlColumn setUrlText(String urlText) {
        this.urlText = urlText;
        return this;
    }

    @Override
    public Context prepareContext(Object object) {
        var ctx = new Context();
        var content = this.getObjectValue(object, this.fieldName);

        if (content != null) {
            content = content.toString();

            if (!content.toString().isBlank()) { this.urlText = "Click"; }
        } else {
            this.urlText = "";
        }

        ctx.setVariable("content", content);
        ctx.setVariable("urlText", this.urlText);
        return ctx;
    }
}

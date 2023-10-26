package adminlte.entity_list_table.communication.http.tables.columns;

import org.thymeleaf.context.Context;

public class UrlColumn extends TextColumn {

    private final String templatePath = "entity_list_table/columns/url_column.html";
    protected String urlText = "";

    public UrlColumn(String fieldName) {
        super(fieldName);
    }

    @Override
    public String getTemplatePath() {
        return this.templatePath;
    }

    public UrlColumn setUrlText(String urlText) {
        this.urlText = urlText;
        return this;
    }

    @Override
    public String getCsvCellContent(Object object) {
        return this.getObjectValue(object, this.fieldName).toString();
    }

    @Override
    public Context prepareContext(Object object) {
        var ctx = new Context();
        var fieldData = this.getObjectValue(object, this.fieldName);

        String urlText = this.urlText;
        String cellContent = "";

        if (fieldData != null) {
            cellContent = fieldData.toString();

            if (cellContent.isBlank()) {
                urlText = "";
            } else {

                if (urlText.isBlank()) {
                    urlText = cellContent;
                }
            }
        }

        ctx.setVariable("content", cellContent);
        ctx.setVariable("urlText", urlText);
        return ctx;
    }
}

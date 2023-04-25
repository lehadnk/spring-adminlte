package adminlte.entity_list_table.communication.http.tables.columns;

import org.thymeleaf.context.Context;

public class ImageInterfacePreviewColumn extends AbstractColumnInterface {
    private String templatePath = "entity_list_table/columns/image_preview_column.html";

    public ImageInterfacePreviewColumn(String fieldName) {
        super(fieldName);
    }

    @Override
    public String getTemplatePath() {
        return this.templatePath;
    }

    public Context prepareContext(Object object)
    {
        var ctx = new Context();
        var content = this.getObjectValue(object, this.fieldName);
        if (content != null) {
            content = content.toString();
        }
        ctx.setVariable("content", content);
        return ctx;
    }
}

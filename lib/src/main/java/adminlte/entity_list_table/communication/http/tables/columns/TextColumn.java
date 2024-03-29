package adminlte.entity_list_table.communication.http.tables.columns;

import org.thymeleaf.context.Context;

import java.util.Objects;

public class TextColumn extends AbstractColumn {

    private String templatePath = "entity_list_table/columns/text_column.html";

    public TextColumn(String fieldName) {
        super(fieldName);
    }

    @Override
    public String getTemplatePath() { return this.templatePath; }

    @Override
    public String getCsvCellContent(Object object) {
        return Objects.toString(this.getObjectValue(object, this.fieldName), "");
    }

    public Context prepareContext(Object object) {
        var ctx = new Context();
        var content = this.getObjectValue(object, this.fieldName);

        if (content != null) { content = content.toString(); }
        ctx.setVariable("content", content);
        return ctx;
    }
}

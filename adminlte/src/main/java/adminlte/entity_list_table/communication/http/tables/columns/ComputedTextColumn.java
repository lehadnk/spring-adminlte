package adminlte.entity_list_table.communication.http.tables.columns;

import org.thymeleaf.context.Context;

import java.util.Objects;

public class ComputedTextColumn extends AbstractColumn {
    private String templatePath = "entity_list_table/columns/text_column.html";
    private String format = null;

    public ComputedTextColumn(String fieldName, String format) {
        super(fieldName);
    }

    @Override
    public String getTemplatePath() {
        return this.templatePath;
    }

    @Override
    public String getCsvCellContent(Object object) {
        return Objects.toString(this.prepareContent(object), "");
    }

    public Context prepareContext(Object object) {
        var ctx = new Context();
        var content = this.prepareContent(object);

        ctx.setVariable("content", content);
        return ctx;
    }

    private String prepareContent(Object object) {
        var content = this.getObjectValue(object, this.fieldName);

        if (content != null) {
            content = content.toString();

            // ActionColumn format
            if (format != null) {
                content = format.replaceAll("{" + fieldName + "}", (String) content);
            }

            return (String) content;
        } else {
            return null;
        }
    }
}
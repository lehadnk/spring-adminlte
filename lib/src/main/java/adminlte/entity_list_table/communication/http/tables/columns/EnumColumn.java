package adminlte.entity_list_table.communication.http.tables.columns;

import org.thymeleaf.context.Context;

public class EnumColumn extends TextColumn {

    public EnumColumn(String fieldName) {
        super(fieldName);
    }

    @Override
    public String getCsvCellContent(Object object) {
        var content = this.getObjectValue(object, this.fieldName);

        return ((DisplayableEnumInterface) content).getDisplayName().toString();
    }

    public Context prepareContext(Object object) {
        var ctx = new Context();
        var content = this.getObjectValue(object, this.fieldName);

        if (content != null) {
            content = ((DisplayableEnumInterface) content).getDisplayName().toString();
        }
        ctx.setVariable("content", content);
        return ctx;
    }
}

package adminlte.entity_list_table.communication.http.tables.columns;

import org.thymeleaf.context.Context;

public interface ColumnDefinitionInterface {
    String getTemplatePath();
    ColumnDefinitionInterface setTitle(String title);
    String getTitle();
    String getFieldName();
    Context prepareContext(Object object);
}

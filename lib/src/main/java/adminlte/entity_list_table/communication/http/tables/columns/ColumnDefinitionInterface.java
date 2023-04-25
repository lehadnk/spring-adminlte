package adminlte.entity_list_table.communication.http.tables.columns;

import org.thymeleaf.context.Context;

public interface ColumnDefinitionInterface {
    public String getTemplatePath();
    public ColumnDefinitionInterface setTitle(String title);
    public String getTitle();
    String getFieldName();

    public Context prepareContext(Object object);
}

package adminlte.entity_list_table.communication.http.tables.columns;

import org.thymeleaf.context.Context;

public interface IColumnDefinition {
    public String getTemplatePath();
    public IColumnDefinition setTitle(String title);
    public String getTitle();
    String getFieldName();

    public Context prepareContext(Object object);
}

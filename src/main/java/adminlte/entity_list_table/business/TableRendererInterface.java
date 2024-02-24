package adminlte.entity_list_table.business;

import adminlte.entity_list_table.communication.http.tables.AbstractTable;

public interface TableRendererInterface {
    public String render(AbstractTable<?> table);
}

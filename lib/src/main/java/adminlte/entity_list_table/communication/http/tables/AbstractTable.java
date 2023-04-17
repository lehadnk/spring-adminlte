package adminlte.entity_list_table.communication.http.tables;

import adminlte.entity_list_table.business.PaginatedEntityListInterface;
import adminlte.entity_list_table.communication.http.tables.columns.IColumnDefinition;

import java.util.ArrayList;

abstract public class AbstractTable<TDto> {
    public final PaginatedEntityListInterface<TDto> entityPaginatedList;
    public ArrayList<IColumnDefinition> columns = new ArrayList<>();
    public String search;

    public AbstractTable(PaginatedEntityListInterface<TDto> entityPaginatedList)
    {
        this.entityPaginatedList = entityPaginatedList;
        this.defineColumns();
    }

    abstract public String getTitle();

    abstract public void defineColumns();

    protected void addColumn(IColumnDefinition column)
    {
        this.columns.add(column);
    }
}
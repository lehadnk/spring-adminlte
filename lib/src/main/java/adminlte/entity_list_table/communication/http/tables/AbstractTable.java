package adminlte.entity_list_table.communication.http.tables;

import adminlte.entity_list_table.business.PaginatedEntityListInterface;
import adminlte.entity_list_table.communication.http.tables.columns.ColumnDefinitionInterface;

import java.util.ArrayList;

abstract public class AbstractTable<TDto> {

    public final PaginatedEntityListInterface<TDto> entityPaginatedList;
    public ArrayList<ColumnDefinitionInterface> columns = new ArrayList<>();
    public String search;
    protected boolean hasSearchButton = false;
    protected boolean jumpToTable = true;
    protected String paginationParameter = "page";
    protected String searchParameter = "search";

    public AbstractTable(PaginatedEntityListInterface<TDto> entityPaginatedList) {
        this.entityPaginatedList = entityPaginatedList;
        this.defineColumns();
    }

    abstract public String getTitle();

    abstract public void defineColumns();

    public void setPaginationParameter(String paginationParameter) { this.paginationParameter = paginationParameter; }

    public void setSearchParameter(String searchParameter) { this.searchParameter = searchParameter; }

    public void setJumpToTable(Boolean jumpToTable) { this.jumpToTable = jumpToTable; }

    protected void addColumn(ColumnDefinitionInterface column) {
        this.columns.add(column);
    }

    public Boolean getHasSearchButton() { return this.hasSearchButton; }

    public Boolean getJumpToTable() { return this.jumpToTable; }

    public String getPaginationParameter() { return this.paginationParameter; }

    public String getSearchParameter() { return this.searchParameter; }
}

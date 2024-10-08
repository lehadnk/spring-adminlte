package adminlte.entity_list_table.communication.http.tables;

import adminlte.entity_list_table.business.PaginatedEntityListInterface;
import adminlte.entity_list_table.communication.http.tables.columns.ColumnDefinitionInterface;

import java.util.ArrayList;
import java.util.List;

abstract public class AbstractTable<TDto> {

    public final PaginatedEntityListInterface<TDto> entityPaginatedList;
    public List<ColumnDefinitionInterface> columns = new ArrayList<>();
    public String search;
    protected boolean hasSearchButton = false;
    protected boolean jumpToTable = true;
    protected String paginationParameter = "page";
    protected String searchParameter = "search";

    public AbstractTable(PaginatedEntityListInterface<TDto> entityPaginatedList) {
        this.entityPaginatedList = entityPaginatedList;
    }

    abstract public String getTitle();

    abstract public void defineColumns();

    public AbstractTable setPaginationParameter(String paginationParameter) {
        this.paginationParameter = paginationParameter;
        return this;
    }

    public AbstractTable setSearchParameter(String searchParameter) {
        this.searchParameter = searchParameter;
        return this;
    }

    public AbstractTable setJumpToTable(Boolean jumpToTable) {
        this.jumpToTable = jumpToTable;
        return this;
    }

    public AbstractTable setHasSearchButton(Boolean hasSearchButton) {
        this.hasSearchButton = hasSearchButton;
        return this;
    }

    protected AbstractTable addColumn(ColumnDefinitionInterface column) {
        this.columns.add(column);
        return this;
    }

    public Boolean getHasSearchButton() {
        return this.hasSearchButton;
    }

    public Boolean getJumpToTable() {
        return this.jumpToTable;
    }

    public String getPaginationParameter() {
        return this.paginationParameter;
    }

    public String getSearchParameter() {
        return this.searchParameter;
    }

    public List<ColumnDefinitionInterface> getCsvColumns() {
        return columns;
    }
}

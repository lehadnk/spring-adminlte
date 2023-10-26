package adminlte.entity_list_table.communication.http.tables;

import adminlte.entity_list_table.business.PaginatedEntityListInterface;
import adminlte.entity_list_table.communication.http.tables.columns.ColumnDefinitionInterface;

import java.util.ArrayList;
import java.util.List;

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

    public void setPaginationParameter(String paginationParameter) {
        this.paginationParameter = paginationParameter;
    }

    public void setSearchParameter(String searchParameter) {
        this.searchParameter = searchParameter;
    }

    public void setJumpToTable(Boolean jumpToTable) {
        this.jumpToTable = jumpToTable;
    }

    public void setHasSearchButton(Boolean hasSearchButton) {
        this.hasSearchButton = hasSearchButton;
    }

    protected void addColumn(ColumnDefinitionInterface column) {
        this.columns.add(column);
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
        return new ArrayList<ColumnDefinitionInterface>();
    }

    public String generateCsv(List<TDto> entities, String fileName, boolean addQuotation) {
        List<ColumnDefinitionInterface> csvColumns = this.getCsvColumns();
        if (csvColumns.isEmpty()) {
            return "";
        }
        StringBuilder csvContent = new StringBuilder();

        // Headers
        for (int i = 0; i < csvColumns.size(); i++) {
            String title = csvColumns.get(i).getTitle();

            // Remove outer double quotations
            title = title.replaceAll("^\"+|\"+$", "");

            if (addQuotation) {
                title = "\"" + title + "\"";
            }
            csvContent.append(title);

            if (i != csvColumns.size() - 1) {
                csvContent.append(",");
            } else {
                csvContent.append("\n");
            }
        }

        // Data rows
        for (TDto entity : entities) {

            for (int i = 0; i < csvColumns.size(); i++) {
                var column = csvColumns.get(i);
                String content = column.getCsvCellContent(entity);

                // Remove outer double quotations
                content = content.replaceAll("^\"+|\"+$", "");

                if (addQuotation) {
                    content = "\"" + content + "\"";
                }

                csvContent.append(content);

                // At least we don't need to use external libraries
                if (i != csvColumns.size() - 1) {
                    csvContent.append(",");
                } else {
                    csvContent.append("\n");
                }
            }
        }

        return csvContent.toString();
    }
}

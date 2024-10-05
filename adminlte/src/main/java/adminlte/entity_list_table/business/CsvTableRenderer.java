package adminlte.entity_list_table.business;

import adminlte.entity_list_table.communication.http.tables.AbstractTable;
import adminlte.entity_list_table.communication.http.tables.columns.ColumnDefinitionInterface;

import java.util.List;

public class CsvTableRenderer implements TableRendererInterface {
    private Boolean addQuotation = true;

    public CsvTableRenderer() { }
    
    public CsvTableRenderer(Boolean addQuotation) {
        this.addQuotation = addQuotation;
    }

    public String render(AbstractTable<?> table) {

        List<ColumnDefinitionInterface> csvColumns = table.getCsvColumns();

        if (csvColumns.isEmpty()) {
            return "";
        }
        StringBuilder csvContent = new StringBuilder();

        // Headers
        for (int i = 0; i < csvColumns.size(); i++) {
            String title = csvColumns.get(i).getTitle();

            // Remove outer double quotations
            title = title.replaceAll("^\"+|\"+$", "");

            if (this.addQuotation) {
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
        for (var entity : table.entityPaginatedList.getEntities()) {

            for (int i = 0; i < csvColumns.size(); i++) {
                var column = csvColumns.get(i);
                String content = column.getCsvCellContent(entity);

                // Remove outer double quotations
                content = content.replaceAll("^\"+|\"+$", "");

                if (this.addQuotation) {
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

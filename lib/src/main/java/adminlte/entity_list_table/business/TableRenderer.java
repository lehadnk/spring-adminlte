package adminlte.entity_list_table.business;

import adminlte.entity_list_table.communication.http.tables.AbstractTable;
import adminlte.entity_list_table.communication.http.tables.columns.ColumnDefinitionInterface;
import adminlte.entity_list_table.communication.http.templates.EntityListTableHtmlTemplate;
import adminlte.entity_list_table.communication.http.templates.TableColumnCellHtmlTemplate;
import adminlte.html_template_renderer.HtmlTemplateRendererService;
import adminlte.i18n.I18nService;

import java.util.ArrayList;
import java.util.HashMap;

public class TableRenderer {

    private final HtmlTemplateRendererService htmlTemplateRendererService;
    private final I18nService i18nService;
    private final ArrayList<String> requiredDtoFields = new ArrayList<>();
    private final HashMap<String, ColumnDefinitionInterface> requiredColumnDefinitions = new HashMap<>();

    public TableRenderer(
        HtmlTemplateRendererService htmlTemplateRendererService,
        I18nService i18nService) {
        this.htmlTemplateRendererService = htmlTemplateRendererService;
        this.i18nService = i18nService;
    }

    public String render(AbstractTable<?> table) {
        var headerTitles = new ArrayList<String>();

        var dataset = new ArrayList<ArrayList<String>>();

        for (var columnDefinition : table.columns) {
            headerTitles.add(columnDefinition.getTitle());
            this.requiredDtoFields.add(columnDefinition.getFieldName());
            this.requiredColumnDefinitions.put(columnDefinition.getFieldName(), columnDefinition);
        }

        for (var entity : table.entityPaginatedList.getEntities()) { dataset.add(this.renderRow(entity)); }

        var visiblePagesCount = 10;
        var startPage = table.entityPaginatedList.getCurrentPage() - visiblePagesCount;

        if (startPage < 1) { startPage = 1; }
        var endPage = table.entityPaginatedList.getCurrentPage() + visiblePagesCount;

        if (endPage > table.entityPaginatedList.getTotalPages()) { endPage = table.entityPaginatedList.getTotalPages(); }

        String footerPaginationLabel;
        if (endPage > 0) {
            Object[] footerLabelArgs = { table.entityPaginatedList.getCurrentPage(), endPage };
            footerPaginationLabel = this.i18nService.formatString("pagination-footer-label", footerLabelArgs);
        } else {
            footerPaginationLabel = this.i18nService.formatString("no-elements-found");
        }


        // String tableId = "pagination_" + table.getPaginationParameter() + "__search_" + table.getSearchParameter();
        // Maybe use a better approach. This ^ looks garbage, the one below this comment is at least reasonable.
        // We need unique table ID that's generated deterministically. If this is too much overhead, we can 
        // always just switch the one above. But it's not going to be unique if the page has more than one fully
        // unconfigured table - e.g. both use same pagination and search. Although at that point it's mistake on them
        String tableId = "table_" + Math.abs((table.getPaginationParameter() + table.getSearchParameter()).hashCode()) % 100;

        var entityListTableHtmlTemplate = new EntityListTableHtmlTemplate(
            table.getTitle(),
            headerTitles,
            dataset,
            table.entityPaginatedList.getCurrentPage(),
            table.entityPaginatedList.getTotalPages(),
            startPage,
            endPage,
            visiblePagesCount,
            table.getHasSearchButton(),
            footerPaginationLabel,
            table.getPaginationParameter(),
            table.getSearchParameter(),
            tableId,
            table.getJumpToTable());
        return this.htmlTemplateRendererService.renderTemplate(entityListTableHtmlTemplate);
    }

    private ArrayList<String> renderRow(Object dto) {
        var result = new ArrayList<String>();

        for (String columnName : this.requiredDtoFields) {
            var cellFieldDefinition = this.requiredColumnDefinitions.get(columnName);

            var template = new TableColumnCellHtmlTemplate(
                cellFieldDefinition.getTemplatePath(),
                cellFieldDefinition.prepareContext(dto));
            var renderedValue = this.htmlTemplateRendererService.renderTemplate(template);
            result.add(renderedValue);
        }

        return result;
    }
}

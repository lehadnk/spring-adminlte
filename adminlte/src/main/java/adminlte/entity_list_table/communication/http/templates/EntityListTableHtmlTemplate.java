package adminlte.entity_list_table.communication.http.templates;

import adminlte.html_template_renderer.business.template.AbstractHtmlLayout;
import adminlte.html_template_renderer.business.template.AbstractHtmlTemplate;

import java.util.List;

public class EntityListTableHtmlTemplate extends AbstractHtmlTemplate {

    private String templatePath = "entity_list_table/entity_list_table.html";

    public EntityListTableHtmlTemplate(
        String title,
        List<String> headerTitles,
        List<List<String>> dataset,
        Integer currentPage,
        Integer pagesTotal,
        Integer startPage,
        Integer endPage,
        Integer visiblePagesCount,
        Boolean hasSearchButton,
        String footerPaginationLabel,
        String pageParameter,
        String searchParameter,
        String tableId,
        Boolean jumpToTable
    ) {
        this.context.setVariable("title", title);
        this.context.setVariable("headerTitles", headerTitles);
        this.context.setVariable("dataset", dataset);
        this.context.setVariable("currentPage", currentPage);
        this.context.setVariable("pagesTotal", pagesTotal);
        this.context.setVariable("startPage", startPage);
        this.context.setVariable("endPage", endPage);
        this.context.setVariable("visiblePagesCount", visiblePagesCount);
        this.context.setVariable("hasSearchButton", hasSearchButton);
        this.context.setVariable("footerPaginationLabel", footerPaginationLabel);
        this.context.setVariable("pageParameter", pageParameter);
        this.context.setVariable("searchParameter", searchParameter);
        this.context.setVariable("tableId", tableId);
        this.context.setVariable("jumpToTable", jumpToTable);
    }

    @Override
    public String getTemplatePath() { return this.templatePath; }

    @Override
    public AbstractHtmlLayout getLayoutTemplate() { return null; }
}

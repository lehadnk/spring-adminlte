package adminlte.entity_list_table.communication.http.templates;

import adminlte.html_template_renderer.business.template.AbstractHtmlLayout;
import adminlte.html_template_renderer.business.template.AbstractHtmlTemplate;

import java.util.ArrayList;

public class EntityListTableHtmlTemplate extends AbstractHtmlTemplate {
    private String templatePath = "entity_list_table/entity_list_table.html";

    public EntityListTableHtmlTemplate(
        String title,
        ArrayList<String> headerTitles,
        ArrayList<ArrayList<String>> dataset,
        Integer currentPage,
        Integer pagesTotal,
        Integer startPage,
        Integer endPage,
        Integer visiblePagesCount,
        Boolean hasSearchButton
    )
    {
        this.context.setVariable("title", title);
        this.context.setVariable("headerTitles", headerTitles);
        this.context.setVariable("dataset", dataset);
        this.context.setVariable("currentPage", currentPage);
        this.context.setVariable("pagesTotal", pagesTotal);
        this.context.setVariable("startPage", startPage);
        this.context.setVariable("endPage", endPage);
        this.context.setVariable("visiblePagesCount", visiblePagesCount);
        this.context.setVariable("hasSearchButton", hasSearchButton);
    }

    @Override
    public String getTemplatePath() {
        return this.templatePath;
    }

    @Override
    public AbstractHtmlLayout getLayoutTemplate() {
        return null;
    }
}

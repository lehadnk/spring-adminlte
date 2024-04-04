package adminlte.entity_list_table.communication.http.templates;

import adminlte.html_template_renderer.business.template.AbstractHtmlLayout;
import adminlte.html_template_renderer.business.template.AbstractHtmlTemplate;
import org.thymeleaf.context.Context;

public class TableColumnCellHtmlTemplate extends AbstractHtmlTemplate {
    private String templatePath;

    public TableColumnCellHtmlTemplate(String templatePath, Context context)
    {
        this.context = context;
        this.templatePath = templatePath;
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

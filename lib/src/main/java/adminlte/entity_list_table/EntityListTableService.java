package adminlte.entity_list_table;

import adminlte.entity_list_table.business.PaginatedEntityListInterface;
import adminlte.entity_list_table.business.TableRenderer;
import adminlte.entity_list_table.communication.http.tables.AbstractTable;
import adminlte.html_template_renderer.HtmlTemplateRendererService;
import adminlte.i18n.I18nService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public class EntityListTableService {
    private final HtmlTemplateRendererService htmlTemplateRendererService;
    private final I18nService i18nService;

    public EntityListTableService(
            HtmlTemplateRendererService htmlTemplateRendererService,
            I18nService i18nService
    ) {
        this.htmlTemplateRendererService = htmlTemplateRendererService;
        this.i18nService = i18nService;
    }

    public String renderTable(AbstractTable<?> table)
    {
        var tableRenderer = new TableRenderer(
                this.htmlTemplateRendererService,
                this.i18nService
        );
        return tableRenderer.render(table);
    }
}

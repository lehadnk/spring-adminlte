package adminlte.entity_list_table;

import adminlte.entity_list_table.business.PaginatedEntityListInterface;
import adminlte.entity_list_table.business.TableRenderer;
import adminlte.entity_list_table.communication.http.tables.AbstractTable;
import adminlte.html_template_renderer.HtmlTemplateRendererService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EntityListTableService {
    private final HtmlTemplateRendererService htmlTemplateRendererService;

    @Autowired
    public EntityListTableService(
            HtmlTemplateRendererService htmlTemplateRendererService
    ) {
        this.htmlTemplateRendererService = htmlTemplateRendererService;
    }

    public String renderTable(AbstractTable<?> table)
    {
        var tableRenderer = new TableRenderer(this.htmlTemplateRendererService);
        return tableRenderer.render(table);
    }
}

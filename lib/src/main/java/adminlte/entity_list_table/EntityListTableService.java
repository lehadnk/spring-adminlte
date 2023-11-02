package adminlte.entity_list_table;

import adminlte.entity_list_table.business.HtmlTableRenderer;
import adminlte.entity_list_table.business.TableRendererInterface;
import adminlte.entity_list_table.communication.http.tables.AbstractTable;
import adminlte.html_template_renderer.HtmlTemplateRendererService;
import adminlte.i18n.I18nService;

public class EntityListTableService {
    private final HtmlTemplateRendererService htmlTemplateRendererService;
    private final I18nService i18nService;

    public EntityListTableService(
            HtmlTemplateRendererService htmlTemplateRendererService,
            I18nService i18nService) {
        this.htmlTemplateRendererService = htmlTemplateRendererService;
        this.i18nService = i18nService;
    }

    public String renderTable(AbstractTable<?> table) {
        var tableRenderer = new HtmlTableRenderer(
                this.htmlTemplateRendererService,
                this.i18nService);

        return this.renderTable(table, tableRenderer);
    }

    public String renderTable(AbstractTable<?> table, TableRendererInterface rendererInterface) {

        return rendererInterface.render(table);
    }

}

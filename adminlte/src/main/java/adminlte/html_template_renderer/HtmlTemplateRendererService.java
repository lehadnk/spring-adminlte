package adminlte.html_template_renderer;

import adminlte.html_template_renderer.business.TemplateRenderer;
import adminlte.html_template_renderer.business.template.AbstractHtmlTemplate;

public class HtmlTemplateRendererService {
    private TemplateRenderer templateRenderer;

    public HtmlTemplateRendererService(
            TemplateRenderer templateRenderer
    ) {
        this.templateRenderer = templateRenderer;
    }

    public String renderTemplate(AbstractHtmlTemplate template) {
        return this.templateRenderer.render(template, null);
    }

    public String renderTemplate(AbstractHtmlTemplate template, Integer adminId) {
        return this.templateRenderer.render(template, adminId);
    }
}

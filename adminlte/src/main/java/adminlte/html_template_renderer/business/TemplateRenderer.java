package adminlte.html_template_renderer.business;

import adminlte.html_template_renderer.HtmlTemplateRendererConfig;
import adminlte.html_template_renderer.business.template.AbstractHtmlTemplate;
import org.thymeleaf.TemplateEngine;

public class TemplateRenderer {
    private final TemplateEngine templateEngine;
    private final HtmlTemplateRendererConfig templateRendererConfig;

    public TemplateRenderer(
        TemplateEngine templateEngine,
        HtmlTemplateRendererConfig templateRendererConfig
    ) {
        this.templateEngine = templateEngine;
        this.templateRendererConfig = templateRendererConfig;
    }

    public String render(AbstractHtmlTemplate template, Integer userId) {
        var templateHtml = this.templateEngine.process(template.getTemplatePath(), template.getContext());
        var layoutTemplate = template.getLayoutTemplate();
        if (layoutTemplate == null) {
            return templateHtml;
        }

        layoutTemplate.setContent(templateHtml);
        layoutTemplate.setProjectName(this.templateRendererConfig.projectName);

        return this.templateEngine.process(layoutTemplate.getTemplatePath(), layoutTemplate.getContext());
    }
}

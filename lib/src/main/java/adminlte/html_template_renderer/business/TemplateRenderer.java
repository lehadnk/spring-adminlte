package adminlte.html_template_renderer.business;

import adminlte.html_template_renderer.HtmlTemplateRendererConfig;
import adminlte.html_template_renderer.business.template.AbstractHtmlTemplate;
import adminlte.session.SessionServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;

import java.util.ArrayList;
import java.util.HashMap;

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
        layoutTemplate.setPageTitle(this.templateRendererConfig.pageTitle);
        layoutTemplate.setProjectName(this.templateRendererConfig.projectName);

        return this.templateEngine.process(layoutTemplate.getTemplatePath(), layoutTemplate.getContext());
    }
}

package adminlte.html_template_renderer;

import adminlte.html_template_renderer.business.TemplateRenderer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.thymeleaf.TemplateEngine;

@Configuration
public class HtmlTemplateRendererBeanConfiguration {
    @Bean
    public HtmlTemplateRendererService createHtmlTemplateRendererService(
            TemplateRenderer templateRenderer
    ) {
        return new HtmlTemplateRendererService(
                templateRenderer
        );
    }

    @Bean
    public HtmlTemplateRendererConfig createHtmlTemplateRendererConfig()
    {
        return new HtmlTemplateRendererConfig();
    }

    @Bean
    public TemplateRenderer createTemplateRenderer(
            TemplateEngine templateEngine,
            HtmlTemplateRendererConfig htmlTemplateRendererConfig
    ) {
        return new TemplateRenderer(
                templateEngine,
                htmlTemplateRendererConfig
        );
    }
}

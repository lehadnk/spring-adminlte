package adminlte.html_template_renderer;

import adminlte.html_template_renderer.business.TemplateRenderer;
import adminlte.session.SessionServiceInterface;
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
    public TemplateRenderer createTemplateRenderer(
            TemplateEngine templateEngine
    ) {
        return new TemplateRenderer(
                templateEngine
        );
    }
}

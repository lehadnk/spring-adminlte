package adminlte.web_form;

import adminlte.html_template_renderer.HtmlTemplateRendererService;
import adminlte.web_form.business.FormRenderer;
import adminlte.web_form.business.FormValidator;
import adminlte.web_form.business.builder.ValidationResultBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebFormBeanConfiguration {
    @Bean
    public WebFormService createWebFormService(HtmlTemplateRendererService htmlTemplateRendererService)
    {
        return new WebFormService(
            new FormRenderer(htmlTemplateRendererService),
            new ValidationResultBuilder(),
            new FormValidator()
        );
    }
}

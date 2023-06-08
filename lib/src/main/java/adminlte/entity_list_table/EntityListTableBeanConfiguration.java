package adminlte.entity_list_table;

import adminlte.entity_list_table.business.TableRenderer;
import adminlte.html_template_renderer.HtmlTemplateRendererService;
import adminlte.i18n.I18nService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EntityListTableBeanConfiguration {
    @Bean
    public EntityListTableService createEntityListTableService(
            HtmlTemplateRendererService htmlTemplateRendererService,
            I18nService i18nService
    ) {
        return new EntityListTableService(
                htmlTemplateRendererService,
                i18nService
        );
    }
}

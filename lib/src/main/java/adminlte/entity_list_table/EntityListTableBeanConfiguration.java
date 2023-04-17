package adminlte.entity_list_table;

import adminlte.entity_list_table.business.TableRenderer;
import adminlte.html_template_renderer.HtmlTemplateRendererService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EntityListTableBeanConfiguration {
    @Bean
    public EntityListTableService createEntityListTableService(
            HtmlTemplateRendererService htmlTemplateRendererService
    ) {
        return new EntityListTableService(
                htmlTemplateRendererService
        );
    }
}

package adminlte.world_map;

import adminlte.html_template_renderer.HtmlTemplateRendererService;
import adminlte.world_map.business.WorldMapWidgetRenderer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WorldMapBeanConfiguration {
    @Bean
    public WorldMapService createWorldMapService(HtmlTemplateRendererService htmlTemplateRendererService, WorldMapConfig worldMapConfig) {
        return new WorldMapService(
            new WorldMapWidgetRenderer(htmlTemplateRendererService, worldMapConfig)
        );
    }

    @Bean
    public WorldMapConfig createWorldMapConfig() {
        return new WorldMapConfig();
    }
}

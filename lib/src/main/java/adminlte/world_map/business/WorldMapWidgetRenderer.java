package adminlte.world_map.business;

import adminlte.html_template_renderer.HtmlTemplateRendererService;
import adminlte.world_map.WorldMapConfig;
import adminlte.world_map.business.exception.NoApiKeyDefinedException;
import adminlte.world_map.communication.WorldMapWidgetTemplate;
import adminlte.world_map.communication.world_map_widget.AbstractWorldMapWidget;
import adminlte.world_map.communication.world_map_widget.GoogleWorldMapWidget;
import adminlte.world_map.communication.world_map_widget.YandexWorldMapWidget;

public class WorldMapWidgetRenderer {
    private final HtmlTemplateRendererService htmlTemplateRendererFacade;
    private final WorldMapConfig worldMapConfig;

    public WorldMapWidgetRenderer(
        HtmlTemplateRendererService htmlTemplateRendererService,
        WorldMapConfig worldMapConfig
    ) {
        this.htmlTemplateRendererFacade = htmlTemplateRendererService;
        this.worldMapConfig = worldMapConfig;
    }

    public String render(AbstractWorldMapWidget<?> widget) {
        var formTemplate = new WorldMapWidgetTemplate(
            getApiKeyByWidget(widget),
            widget.lat,
            widget.lng,
            widget.zoom,
            widget.points,
            widget.getTemplatePath()
        );
        return this.htmlTemplateRendererFacade.renderTemplate(formTemplate);
    }

    private String getApiKeyByWidget(AbstractWorldMapWidget<?> widget) {
        if (widget instanceof GoogleWorldMapWidget) {
            if (worldMapConfig.googleApiKey == null) {
                throw new NoApiKeyDefinedException("Google");
            }
            return worldMapConfig.googleApiKey;
        }
        if (widget instanceof YandexWorldMapWidget) {
            if (worldMapConfig.yandexApiKey == null) {
                throw new NoApiKeyDefinedException("Yandex");
            }
            return worldMapConfig.yandexApiKey;
        }
        return null;
    }
}

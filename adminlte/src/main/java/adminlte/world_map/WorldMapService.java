package adminlte.world_map;

import adminlte.world_map.business.WorldMapWidgetRenderer;
import adminlte.world_map.communication.world_map_widget.AbstractWorldMapWidget;

public class WorldMapService {
    private final WorldMapWidgetRenderer worldMapWidgetRenderer;

    public WorldMapService(
        WorldMapWidgetRenderer worldMapWidgetRenderer
    ) {
        this.worldMapWidgetRenderer = worldMapWidgetRenderer;
    }

    public String render(AbstractWorldMapWidget<?> widget) {
        return worldMapWidgetRenderer.render(widget);
    }
}

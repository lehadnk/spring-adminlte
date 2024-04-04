package adminlte.world_map.communication.world_map_widget;

public class GoogleWorldMapWidget extends AbstractWorldMapWidget<GoogleWorldMapWidget> {
    private final String templatePath = "world_map/world_map_widget/google_world_map_widget.html";

    @Override
    public String getTemplatePath() {
        return this.templatePath;
    }
}

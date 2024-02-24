package adminlte.world_map.communication.world_map_widget;

public class YandexWorldMapWidget extends AbstractWorldMapWidget<YandexWorldMapWidget> {
    private final String templatePath = "world_map/world_map_widget/yandex_world_map_widget.html";

    @Override
    public String getTemplatePath() {
        return this.templatePath;
    }
}

package adminlte.world_map.communication;

public class WorldMapWidgetPoint {
    public double lat;
    public double lng;
    public String name;
    public String description;
    public boolean isSpecial = false;

    public WorldMapWidgetPoint() {}

    public WorldMapWidgetPoint(double lat, double lng, String name, String description) {
        this.lat = lat;
        this.lng = lng;
        this.name = name;
        this.description = description;
    }

    public WorldMapWidgetPoint setSpecial() {
        this.isSpecial = true;
        return this;
    }
}

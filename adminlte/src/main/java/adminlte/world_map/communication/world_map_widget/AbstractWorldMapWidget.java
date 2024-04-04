package adminlte.world_map.communication.world_map_widget;

import adminlte.world_map.communication.WorldMapWidgetPoint;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractWorldMapWidget<T extends AbstractWorldMapWidget<T>> implements IWorldMapWidget {
    public double lat = 0.0;
    public double lng = 0.0;
    public int zoom = 10;
    public List<WorldMapWidgetPoint> points = new ArrayList<>();

    abstract public String getTemplatePath();

    @SuppressWarnings("unchecked")
    protected T casted()
    {
        return (T) this;
    }

    public T setLat(double lat) {
        this.lat = lat;
        return this.casted();
    }

    public T setLng(double lng) {
        this.lng = lng;
        return this.casted();
    }

    public T setZoom(int zoom) {
        this.zoom = zoom;
        return this.casted();
    }

    public T addPoint(double lat, double lng, String name, String description) {
        return addPoint(lat, lng, name, description, false);
    }

    public T addPoint(double lat, double lng, String name, String description, boolean isSpecial) {
        var point = new WorldMapWidgetPoint(lat, lng, name, description);
        if (isSpecial) {
            point.setSpecial();
        }
        this.points.add(point);
        return this.casted();
    }
}

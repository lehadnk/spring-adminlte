package adminlte.world_map.communication.world_map_widget;

public interface IWorldMapWidget {
    IWorldMapWidget setLat(double lat);
    IWorldMapWidget setLng(double lng);
    IWorldMapWidget setZoom(int zoom);
    IWorldMapWidget addPoint(double lat, double lng, String name, String description);
}

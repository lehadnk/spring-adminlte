package adminlte.world_map;

import org.springframework.beans.factory.annotation.Value;

public class WorldMapConfig {
    @Value("${adminlte.world-map.google-api-key:#{null}}")
    public String googleApiKey;

    @Value("${adminlte.world-map.yandex-api-key:#{null}}")
    public String yandexApiKey;
}

package adminlte.world_map.business.exception;

public class NoApiKeyDefinedException extends RuntimeException {
    public NoApiKeyDefinedException(String provider)
    {
        super("No api key defined for " + provider + ". Please consider adding it to adminlte.world-map." + provider.toLowerCase() + "-api-key");
    }
}

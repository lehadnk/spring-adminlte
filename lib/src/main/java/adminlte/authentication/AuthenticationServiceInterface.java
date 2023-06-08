package adminlte.authentication;

import java.util.Locale;

public interface AuthenticationServiceInterface {
    Integer getCurrentUserIdentifier();
    Locale getUserLocale();
}

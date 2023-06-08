package adminlte.i18n.business;


import adminlte.authentication.AuthenticationServiceInterface;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

public class TranslatedStringFormatter {
    private final Map<String, ResourceBundle> messages = new HashMap<>();
    private final AuthenticationServiceInterface authenticationService;

    public TranslatedStringFormatter(
            AuthenticationServiceInterface authenticationService
    ) {
        this.authenticationService = authenticationService;
        var usLocale = new Locale.Builder().setLanguage("en").setRegion("US").build();
        this.messages.put(this.getLocaleCode(usLocale), ResourceBundle.getBundle("resource-bundles/adminlte", usLocale));
        var ruLocale = new Locale.Builder().setLanguage("ru").setRegion("RU").build();
        this.messages.put(this.getLocaleCode(ruLocale), ResourceBundle.getBundle("resource-bundles/adminlte", ruLocale));
    }

    public String format(String id, Object[] args)
    {
        var locale = this.authenticationService.getUserLocale();
        var localeCode = this.getLocaleCode(locale);
        if (!this.messages.containsKey(localeCode)) {
            localeCode = "en_US";
        }

        var messageFormat = new MessageFormat(
                this.messages.get(localeCode).getString(id)
        );
        messageFormat.setLocale(locale);

        return messageFormat.format(args);
    }

    private String getLocaleCode(Locale locale)
    {
        return locale.getLanguage() + "_" + locale.getCountry();
    }
}

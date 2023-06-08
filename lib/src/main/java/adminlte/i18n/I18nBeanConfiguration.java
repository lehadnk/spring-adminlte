package adminlte.i18n;

import adminlte.authentication.AuthenticationServiceInterface;
import adminlte.i18n.business.TranslatedStringFormatter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class I18nBeanConfiguration {
    @Bean
    public I18nService createI18nService(
            TranslatedStringFormatter translatedStringFormatter
    ) {
        return new I18nService(
                translatedStringFormatter
        );
    }

    @Bean
    public TranslatedStringFormatter createTranslatedStringFormatter(
            AuthenticationServiceInterface authenticationService
    ) {
        return new TranslatedStringFormatter(authenticationService);
    }
}

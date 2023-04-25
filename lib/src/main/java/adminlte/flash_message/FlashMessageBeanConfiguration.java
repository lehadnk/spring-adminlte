package adminlte.flash_message;

import adminlte.authentication.AuthenticationServiceInterface;
import adminlte.flash_message.business.FlashMessageSessionStore;
import adminlte.session.SessionServiceInterface;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FlashMessageBeanConfiguration {
    @Bean
    public FlashMessageService createFlashMessageService(
            FlashMessageSessionStore flashMessageSessionStore
    ) {
        return new FlashMessageService(
                flashMessageSessionStore
        );
    }

    @Bean
    public FlashMessageSessionStore createFlashMessageSessionStore(
            AuthenticationServiceInterface authenticationService,
            SessionServiceInterface sessionService
    ) {
        return new FlashMessageSessionStore(
                authenticationService,
                sessionService
        );
    }
}

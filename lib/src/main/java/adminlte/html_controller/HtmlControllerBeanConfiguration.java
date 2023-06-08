package adminlte.html_controller;

import adminlte.flash_message.FlashMessageService;
import adminlte.html_controller.communication.http.layout.LayoutFactory;
import adminlte.i18n.I18nService;
import adminlte.navigation_menu.NavigationMenuService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HtmlControllerBeanConfiguration {
    @Bean
    public LayoutFactory createLayoutFactory(
            NavigationMenuService navigationMenuService,
            FlashMessageService flashMessageService,
            I18nService i18nService,
            HtmlControllerConfig htmlControllerConfig
    ) {
        return new LayoutFactory(
                navigationMenuService,
                flashMessageService,
                i18nService,
                htmlControllerConfig
        );
    }

    @Bean
    public HtmlControllerConfig createHtmlControllerConfig()
    {
        return new HtmlControllerConfig();
    }
}

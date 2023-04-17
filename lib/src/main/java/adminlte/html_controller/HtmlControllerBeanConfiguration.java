package adminlte.html_controller;

import adminlte.html_controller.communication.http.layout.LayoutFactory;
import adminlte.navigation_menu.NavigationMenuService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HtmlControllerBeanConfiguration {
    @Bean
    public LayoutFactory createLayoutFactory(
            NavigationMenuService navigationMenuService
    ) {
        return new LayoutFactory(navigationMenuService);
    }
}

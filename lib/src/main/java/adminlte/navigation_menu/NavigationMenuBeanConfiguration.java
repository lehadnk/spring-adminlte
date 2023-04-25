package adminlte.navigation_menu;

import adminlte.html_template_renderer.HtmlTemplateRendererService;
import adminlte.navigation_menu.business.MenuRenderer;
import adminlte.navigation_menu.business.NavigationMenuBuilder;
import adminlte.navigation_menu.communication.AbstractMenuItemsProviderInterface;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class NavigationMenuBeanConfiguration {
    @Bean
    public NavigationMenuService createNavigationMenuService(
            HtmlTemplateRendererService htmlTemplateRendererService,
            NavigationMenuDependencyProviderInterface navigationMenuDependencyProvider
    )
    {
        return new NavigationMenuService(
                new MenuRenderer(htmlTemplateRendererService),
                new NavigationMenuBuilder(navigationMenuDependencyProvider)
        );
    }

    @Bean
    public NavigationMenuDependencyProviderInterface createNavigationMenuDependencyProvider(
            List<AbstractMenuItemsProviderInterface> menuItemsProviders
    )
    {
        return new NavigationMenuDependencyProvider(menuItemsProviders);
    }
}

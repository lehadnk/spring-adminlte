package adminlte.navigation_menu;

import adminlte.html_template_renderer.HtmlTemplateRendererService;
import adminlte.navigation_menu.business.MenuRenderer;
import adminlte.navigation_menu.business.NavigationMenuBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
}

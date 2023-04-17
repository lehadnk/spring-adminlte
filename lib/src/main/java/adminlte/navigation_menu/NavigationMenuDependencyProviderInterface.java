package adminlte.navigation_menu;

import adminlte.navigation_menu.communication.AbstractMenuItemsProvider;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface NavigationMenuDependencyProviderInterface {
    public List<AbstractMenuItemsProvider> getMenuItemProviders();
}

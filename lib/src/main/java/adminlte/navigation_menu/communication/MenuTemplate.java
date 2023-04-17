package adminlte.navigation_menu.communication;

import adminlte.html_template_renderer.business.template.AbstractHtmlLayout;
import adminlte.html_template_renderer.business.template.AbstractHtmlTemplate;

import java.util.List;

public class MenuTemplate extends AbstractHtmlTemplate {
    private String templatePath = "navigation_menu/menu.html";

    public MenuTemplate(List<String> menuItems)
    {
        this.context.setVariable("menuItems", menuItems);
    }

    @Override
    public String getTemplatePath() {
        return this.templatePath;
    }

    @Override
    public AbstractHtmlLayout getLayoutTemplate() {
        return null;
    }
}

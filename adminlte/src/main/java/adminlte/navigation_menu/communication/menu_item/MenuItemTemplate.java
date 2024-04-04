package adminlte.navigation_menu.communication.menu_item;

import adminlte.html_template_renderer.business.template.AbstractHtmlLayout;
import adminlte.html_template_renderer.business.template.AbstractHtmlTemplate;

public class MenuItemTemplate extends AbstractHtmlTemplate {
    private String templatePath;

    public MenuItemTemplate(
            String title,
            String url,
            String templatePath
    )
    {
        this.context.setVariable("title", title);
        this.context.setVariable("url", url);
        this.templatePath = templatePath;
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

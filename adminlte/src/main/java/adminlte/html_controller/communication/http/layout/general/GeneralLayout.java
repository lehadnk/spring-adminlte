package adminlte.html_controller.communication.http.layout.general;

import adminlte.html_template_renderer.business.template.AbstractHtmlLayout;

public class GeneralLayout extends AbstractHtmlLayout {
    final private String templatePath = "html_controller/layout/general.html";

    @Override
    public String getTemplatePath() {
        return this.templatePath;
    }
}

package adminlte.html_template_renderer;

import org.springframework.beans.factory.annotation.Value;

public class HtmlTemplateRendererConfig {
    @Value("${adminlte.project-name}")
    public String projectName;

    @Value("${adminlte.page-title}")
    public String pageTitle;
}

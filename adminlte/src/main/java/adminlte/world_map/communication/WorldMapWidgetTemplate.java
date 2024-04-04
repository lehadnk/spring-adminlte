package adminlte.world_map.communication;

import adminlte.html_template_renderer.business.template.AbstractHtmlLayout;
import adminlte.html_template_renderer.business.template.AbstractHtmlTemplate;

import java.util.List;

public class WorldMapWidgetTemplate extends AbstractHtmlTemplate {
    private String templatePath;

    public WorldMapWidgetTemplate(
        String apiKey,
        double lat,
        double lng,
        int zoom,
        List<WorldMapWidgetPoint> points,
        String templatePath
    ) {
        this.context.setVariable("apiKey", apiKey);
        this.context.setVariable("lat", lat);
        this.context.setVariable("lng", lng);
        this.context.setVariable("zoom", zoom);
        this.context.setVariable("points", points);
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

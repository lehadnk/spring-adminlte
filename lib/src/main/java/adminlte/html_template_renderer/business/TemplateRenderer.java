package adminlte.html_template_renderer.business;

import adminlte.html_template_renderer.business.template.AbstractHtmlTemplate;
import adminlte.session.SessionServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;

import java.util.ArrayList;
import java.util.HashMap;

@Component
public class TemplateRenderer {
    private final TemplateEngine templateEngine;
    private final SessionServiceInterface sessionService;

    @Autowired
    public TemplateRenderer(
        TemplateEngine templateEngine,
        SessionServiceInterface sessionService
    ) {
        this.templateEngine = templateEngine;
        this.sessionService = sessionService;
    }

    public String render(AbstractHtmlTemplate template, Integer userId) {
        var additionalContext = new HashMap<String, Object>();

        var adminSessionData = this.sessionService.getUserSessionData(userId);
        if (adminSessionData != null) {
            if (adminSessionData.errorMessages.size() > 0) {
                var errorFlashMessage = String.join(". ", adminSessionData.errorMessages);
                adminSessionData.errorMessages = new ArrayList<>();
                additionalContext.put("errorFlashMessage", errorFlashMessage);
            }
            if (adminSessionData.successMessages.size() > 0) {
                var successFlashMessage = String.join(". ", adminSessionData.successMessages);
                adminSessionData.successMessages = new ArrayList<>();
                additionalContext.put("successFlashMessage", successFlashMessage);
            }
        }

        if (!additionalContext.isEmpty()) {
            this.sessionService.setUserSessionData(userId, adminSessionData);
            template.updateContext(additionalContext);
        }
        var templateHtml = this.templateEngine.process(template.getTemplatePath(), template.getContext());
        var layoutTemplate = template.getLayoutTemplate();
        if (layoutTemplate == null) {
            return templateHtml;
        }

        layoutTemplate.setContent(templateHtml);
        layoutTemplate.updateContext(additionalContext);
        return this.templateEngine.process(layoutTemplate.getTemplatePath(), layoutTemplate.getContext());
    }
}

package adminlte.html_controller.business;

import adminlte.entity_list_table.EntityListTableService;
import adminlte.html_controller.communication.http.layout.LayoutFactory;
import adminlte.html_template_renderer.HtmlTemplateRendererService;
import adminlte.session.SessionServiceInterface;
import adminlte.web_form.WebFormService;
import adminlte.html_controller.business.exception.ForceRedirectException;
import adminlte.html_template_renderer.business.template.AbstractHtmlTemplate;
import org.springframework.stereotype.Component;
import adminlte.web_form.business.converter.BooleanEditor;
import adminlte.web_form.business.converter.LocalDateTimeEditor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;

import java.time.LocalDateTime;

public class AbstractHtmlController {
    protected LayoutFactory layoutFactory;
    protected HtmlTemplateRendererService htmlTemplateRendererService;
    protected WebFormService webFormService;
    protected EntityListTableService entityListTableService;
    protected SessionServiceInterface sessionService;

    public AbstractHtmlController(
            LayoutFactory layoutFactory,
            HtmlTemplateRendererService htmlTemplateRendererService,
            WebFormService webFormService,
            EntityListTableService entityListTableService,
            SessionServiceInterface sessionService
    ) {
        this.layoutFactory = layoutFactory;
        this.htmlTemplateRendererService = htmlTemplateRendererService;
        this.webFormService = webFormService;
        this.entityListTableService = entityListTableService;
        this.sessionService = sessionService;
    }

    protected String renderTemplate(AbstractHtmlTemplate template) {
        return this.htmlTemplateRendererService.renderTemplate(template);
    }

    protected ResponseEntity<String> redirect(String redirectUrl) {
        return ResponseEntity
            .status(HttpStatus.FOUND)
            .header(HttpHeaders.LOCATION, redirectUrl)
            .body(null);
    }

    @ExceptionHandler(ForceRedirectException.class)
    public ResponseEntity<String> handleForceRedirectException(final ForceRedirectException e) {
        var redirectUrl = e.getMessage();
        return this.redirect(redirectUrl);
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(
            LocalDateTime.class,
            new LocalDateTimeEditor()
        );
        binder.registerCustomEditor(
            Boolean.class,
            new BooleanEditor()
        );
    }
}

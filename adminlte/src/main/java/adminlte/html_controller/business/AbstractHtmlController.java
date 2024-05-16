package adminlte.html_controller.business;

import adminlte.authentication.AuthenticationServiceInterface;
import adminlte.entity_list_table.EntityListTableService;
import adminlte.entity_list_table.business.TableRendererInterface;
import adminlte.entity_list_table.communication.http.tables.AbstractTable;
import adminlte.flash_message.FlashMessageService;
import adminlte.html_controller.business.exception.ForceRedirectException;
import adminlte.html_controller.communication.http.layout.LayoutFactory;
import adminlte.html_template_renderer.HtmlTemplateRendererService;
import adminlte.html_template_renderer.business.template.AbstractHtmlTemplate;
import adminlte.session.SessionServiceInterface;
import adminlte.web_form.WebFormService;
import adminlte.web_form.business.converter.BooleanEditor;
import adminlte.web_form.business.converter.LocalDateTimeEditor;
import adminlte.web_form.communication.AbstractWebForm;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;

import java.time.LocalDateTime;

public class AbstractHtmlController {
    protected final LayoutFactory layoutFactory;
    protected final HtmlTemplateRendererService htmlTemplateRendererService;
    protected final WebFormService webFormService;
    protected final EntityListTableService entityListTableService;
    protected final SessionServiceInterface sessionService;
    protected final AuthenticationServiceInterface authenticationService;
    protected final FlashMessageService flashMessageService;

    public AbstractHtmlController(
            LayoutFactory layoutFactory,
            HtmlTemplateRendererService htmlTemplateRendererService,
            WebFormService webFormService,
            EntityListTableService entityListTableService,
            SessionServiceInterface sessionService,
            AuthenticationServiceInterface authenticationService,
            FlashMessageService flashMessageService) {
        this.layoutFactory = layoutFactory;
        this.htmlTemplateRendererService = htmlTemplateRendererService;
        this.webFormService = webFormService;
        this.entityListTableService = entityListTableService;
        this.sessionService = sessionService;
        this.authenticationService = authenticationService;
        this.flashMessageService = flashMessageService;
    }

    protected String renderTemplate(AbstractHtmlTemplate template) {
        return this.htmlTemplateRendererService.renderTemplate(template);
    }

    protected String renderForm(AbstractWebForm<?> form) {
        return this.webFormService.renderForm(form);
    }

    protected String renderTable(AbstractTable<?> table) {
        return this.entityListTableService.renderTable(table);
    }

    protected String renderTable(AbstractTable<?> table, TableRendererInterface renderInterface) {
        return this.entityListTableService.renderTable(table, renderInterface);
    }

    protected Boolean isFormValid(AbstractWebForm<?> form) {
        return this.webFormService.isFormValid(form);
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
                new LocalDateTimeEditor());

        binder.registerCustomEditor(
                Boolean.class,
                new BooleanEditor());
    }

    public void addErrorMessage(String message) {
        this.flashMessageService.addErrorMessage(message);
    }

    public void addSuccessMessage(String message) {
        this.flashMessageService.addSuccessMessage(message);
    }
}

package adminlte.web_form.business;

import adminlte.html_template_renderer.HtmlTemplateRendererService;
import adminlte.web_form.communication.AbstractWebForm;
import adminlte.web_form.communication.FormElementTemplate;
import adminlte.web_form.communication.FormTemplate;
import adminlte.web_form.communication.SubmitButtonsTemplate;
import adminlte.web_form.communication.form_elements.WebFormFieldElementInterface;
import adminlte.web_form.dto.ValidationResult;

import java.util.ArrayList;

public class FormRenderer {
    private HtmlTemplateRendererService htmlTemplateRendererFacade;

    public FormRenderer(HtmlTemplateRendererService htmlTemplateRendererService)
    {
        this.htmlTemplateRendererFacade = htmlTemplateRendererService;
    }

    public String render(AbstractWebForm<?> form)
    {
        StringBuilder contents = new StringBuilder();

        for(String elementKey : form.elements.keySet())
        {
            var elementContents = this.renderFormElement(elementKey, form.elements.get(elementKey));
            if (elementContents != null) {
                contents.append(elementContents);
            }
        }

        var submitButton = this.renderSubmitButtons(form);
        if (submitButton != null) {
            contents.append(submitButton);
        }

        var formTemplate = new FormTemplate(form.getActionUrl(), form.getEnctype(), contents.toString(), form.validationErrorMessages, form.simpleLayout);
        return this.htmlTemplateRendererFacade.renderTemplate(formTemplate);
    }

    private String renderSubmitButtons(AbstractWebForm<?> form)
    {
        if (form.submitButtons.isEmpty()) {
            return null;
        }

        var submitButtonsTemplate = new SubmitButtonsTemplate(form.submitButtons);
        return this.htmlTemplateRendererFacade.renderTemplate(submitButtonsTemplate);
    }

    private String renderFormElement(String name, WebFormFieldElementInterface<?> element) {
        var validationErrors = new ArrayList<String>();
        for (ValidationResult validationResult: element.getValidationResults()) {
            if (!validationResult.isValid) {
                validationErrors.add(validationResult.errorMessage);
            }
        }

        var formElementTemplate = new FormElementTemplate(name, element.getLabel(), element.getValue(), validationErrors, element.getTemplatePath());
        formElementTemplate.updateContext(element.getContextVariables());
        return this.htmlTemplateRendererFacade.renderTemplate(formElementTemplate);
    }
}

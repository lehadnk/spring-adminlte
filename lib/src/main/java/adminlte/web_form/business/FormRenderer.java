package adminlte.web_form.business;

import adminlte.html_template_renderer.HtmlTemplateRendererService;
import adminlte.web_form.communication.AbstractWebForm;
import adminlte.web_form.communication.FormElementTemplate;
import adminlte.web_form.communication.FormTemplate;
import adminlte.web_form.communication.form_elements.WebFormElementInterface;
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

        var submitButton = this.renderSubmitButton(form);
        if (submitButton != null) {
            contents.append(submitButton);
        }

        var formTemplate = new FormTemplate(form.getActionUrl(), form.getEnctype(), contents.toString(), form.validationErrorMessages);
        return this.htmlTemplateRendererFacade.renderTemplate(formTemplate);
    }

    private String renderSubmitButton(AbstractWebForm<?> form)
    {
        if (form.submitButton == null) {
            return null;
        }

        return this.renderFormElement("submit", form.submitButton);
    }

    private String renderFormElement(String name, WebFormElementInterface element) {
        ArrayList<String> validationErrors = new ArrayList<>();
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

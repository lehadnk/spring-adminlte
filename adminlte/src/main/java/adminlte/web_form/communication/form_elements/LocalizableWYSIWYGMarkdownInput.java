package adminlte.web_form.communication.form_elements;

import adminlte.web_form.business.glossary.GlossaryFacadeInterface;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LocalizableWYSIWYGMarkdownInput extends AbstractFormFieldElement<LocalizableWYSIWYGMarkdownInput, String> implements Localizable {
    private final String templatePath = "web_form/form_elements/localizable_wysiwyg_markdown_input.html";

    private final String glossaryKey;
    private final List<String> languages;
    private final Map<String, String> textMapByLanguage;
    private Boolean hasUpdateWithRawTextInput = false;

    public LocalizableWYSIWYGMarkdownInput(String glossaryKey, GlossaryFacadeInterface glossaryFacade) {
        this.glossaryKey = glossaryKey;
        this.languages = glossaryFacade.getAvailableLanguages();
        this.textMapByLanguage = glossaryFacade.getGlossaryTextMapByLanguage(this.glossaryKey);

        for (var language : languages) {
            if (!this.textMapByLanguage.containsKey(language)) {
                this.textMapByLanguage.put(language, "");
            }
        }
    }

    public LocalizableWYSIWYGMarkdownInput(GlossaryFacadeInterface glossaryFacade) {
        this.glossaryKey = "";
        this.languages = glossaryFacade.getAvailableLanguages();
        this.textMapByLanguage = glossaryFacade.getGlossaryTextMapByLanguage(this.glossaryKey);

        for (var language : languages) {
            if (!this.textMapByLanguage.containsKey(language)) {
                this.textMapByLanguage.put(language, "");
            }
        }
    }

    public String getGlossaryKey() {
        return glossaryKey;
    }

    @Override
    public String getTemplatePath() {
        return this.templatePath;
    }

    public WebFormElementInterface addLanguage(String language) {
        this.languages.add(language);
        return this;
    }

    public Map<String, Object> getContextVariables() {
        var context = new HashMap<String, Object>();
        context.put("glossaryKey", this.glossaryKey);
        context.put("languages", this.languages);
        context.put("textMapByLanguage", this.textMapByLanguage);
        context.put("hasUpdateWithRawTextInput", this.hasUpdateWithRawTextInput);
        context.put("id", this.id);

        return context;
    }

    private LocalizableWYSIWYGMarkdownInput setHasUpdateWithRawTextInput(Boolean hasUpdateWithRawTextInput) {
        this.hasUpdateWithRawTextInput = hasUpdateWithRawTextInput;
        return this;
    }

    public LocalizableWYSIWYGMarkdownInput setValue(Map<String, String> value) {
        if (value == null) {
            return this;
        }
        this.textMapByLanguage.putAll(value);
        return this;
    }
}

package adminlte.web_form.communication.form_elements;

import adminlte.web_form.WebFormDependencyProviderInterface;
import adminlte.web_form.business.glossary.GlossaryFacadeInterface;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LocalizableTextarea extends AbstractFormElement implements Localizable {
    private final String glossaryKey;
    private final List<String> languages;
    private final Map<String, String> textMapByLanguage;
    private String textTransform = "";
    private int rows = 10;
    private WebFormDependencyProviderInterface dependencyProvider;

    public LocalizableTextarea(String glossaryKey, GlossaryFacadeInterface glossaryFacade) {
        this.glossaryKey = glossaryKey;
        this.languages = this.dependencyProvider.getAvailableLanguages();
        this.textMapByLanguage = glossaryFacade.getGlossaryTextMapByLanguage(this.glossaryKey);

        for (var language : languages) {
            if (!this.textMapByLanguage.containsKey(language)) {
                this.textMapByLanguage.put(language, "");
            }
        }
    }

    public LocalizableTextarea(int rows) {
        this.languages = this.dependencyProvider.getAvailableLanguages();
        this.textMapByLanguage = new HashMap<String, String>();
        for (var language : languages) {
            this.textMapByLanguage.put(language, "");
        }
        this.glossaryKey = "";
        this.rows = rows;
    }

    public String getGlossaryKey() {
        return glossaryKey;
    }

    @Override
    public String getTemplatePath() {
        return "web_form/form_elements/localizable_textarea.html";
    }

    public LocalizableTextarea setTextTransform(String textTransform) {
        this.textTransform = textTransform;
        return this;
    }

    public WebFormElementInterface addLanguage(String language) {
        this.languages.add(language);
        return this;
    }

    public Map<String, Object> getContextVariables() {
        return Map.of(
            "textTransform", this.textTransform,
            "glossaryKey", this.glossaryKey,
            "languages", this.languages,
            "textMapByLanguage", this.textMapByLanguage,
            "rows", this.rows
        );
    }

    public LocalizableTextarea setValue(Map<String, String> value) {
        if (value == null) {
            return this;
        }
        this.textMapByLanguage.putAll(value);
        return this;
    }
}

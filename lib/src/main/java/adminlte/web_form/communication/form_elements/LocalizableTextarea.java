package adminlte.web_form.communication.form_elements;

import adminlte.web_form.business.glossary.GlossaryFacadeInterface;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.*;

public class LocalizableTextarea extends AbstractFormFieldElement<LocalizableTextarea, String> implements Localizable {
    private final String templatePath = "web_form/form_elements/localizable_textarea.html";

    private final String glossaryKey;
    private List<String> languages;
    private final Map<String, String> textMapByLanguage;
    private String textTransform = "";
    private int rows = 10;

    public LocalizableTextarea(String glossaryKey, GlossaryFacadeInterface glossaryFacade) {
        this.glossaryKey = glossaryKey;
        this.languages = glossaryFacade.getAvailableLanguages();
        this.textMapByLanguage = glossaryFacade.getGlossaryTextMapByLanguage(this.glossaryKey);

        for (var language : languages) {
            if (!this.textMapByLanguage.containsKey(language)) {
                this.textMapByLanguage.put(language, "");
            }
        }
    }

    public LocalizableTextarea(int rows, GlossaryFacadeInterface glossaryFacade) {
        this.languages = glossaryFacade.getAvailableLanguages();
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
        return this.templatePath;
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
                "required", this.required,
                "textTransform", this.textTransform,
                "glossaryKey", this.glossaryKey,
                "languages", this.languages,
                "textMapByLanguage", this.textMapByLanguage,
                "rows", this.rows);
    }

    public LocalizableTextarea setValue(Map<String, String> value) {
        if (value == null) {
            return this;
        }
        var objectMapper = new ObjectMapper();

        try {
            this.value = objectMapper.writeValueAsString(value);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        this.textMapByLanguage.putAll(value);
        return this;
    }

    public LocalizableTextarea setLanguages(List<String> languages) {
        this.languages = languages;
        return this;
    }
}

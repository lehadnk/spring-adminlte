package adminlte.web_form.communication.form_elements;

import adminlte.web_form.business.glossary.GlossaryFacadeInterface;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.*;

public class LocalizableInput extends AbstractFormFieldElement<LocalizableInput, String> implements Localizable {
    private final String templatePath = "web_form/form_elements/localizable_input.html";

    private final String glossaryKey;
    private List<String> languages;
    private final Map<String, String> textMapByLanguage;

    public LocalizableInput(String glossaryKey, GlossaryFacadeInterface glossaryFacade) {
        this.glossaryKey = glossaryKey;
        this.languages = glossaryFacade.getAvailableLanguages();
        this.textMapByLanguage = glossaryFacade.getGlossaryTextMapByLanguage(this.glossaryKey);

        for (var language : languages) {
            if (!this.textMapByLanguage.containsKey(language)) {
                this.textMapByLanguage.put(language, "");
            }
        }
    }

    public LocalizableInput(GlossaryFacadeInterface glossaryFacade) {
        this.glossaryKey = "";
        this.textMapByLanguage = new HashMap<>();
        this.languages = glossaryFacade.getAvailableLanguages();

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
        return Map.of(
                "required", this.required,
                "glossaryKey", this.glossaryKey,
                "languages", this.languages,
                "textMapByLanguage", this.textMapByLanguage);
    }

    public LocalizableInput setValue(Map<String, String> value) {
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

    public LocalizableInput setLanguages(List<String> languages) {
        this.languages = languages;
        return this;
    }
}

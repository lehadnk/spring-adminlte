package adminlte.web_form.dto;

import java.util.HashMap;
import java.util.Map;

public class LocalizationData {
    private Map<String, String> localizations = new HashMap<>();

    public void setLocalization(String language, String value)
    {
        this.localizations.put(language, value);
    }

    public Map<String, String> toMap() {
        return this.localizations;
    }

    public String getValueByLanguage(String languageCode) {
        return this.localizations.get(languageCode);
    }
}
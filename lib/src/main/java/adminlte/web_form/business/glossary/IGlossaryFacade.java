package adminlte.web_form.business.glossary;

import java.util.Map;

public interface IGlossaryFacade {
    public Map<String, String> getGlossaryTextMapByLanguage(String key);
}

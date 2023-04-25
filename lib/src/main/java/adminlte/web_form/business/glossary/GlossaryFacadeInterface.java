package adminlte.web_form.business.glossary;

import java.util.Map;

public interface GlossaryFacadeInterface {
    public Map<String, String> getGlossaryTextMapByLanguage(String key);
}

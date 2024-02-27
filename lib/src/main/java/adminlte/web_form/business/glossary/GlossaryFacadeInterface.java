package adminlte.web_form.business.glossary;

import java.util.List;
import java.util.Map;

public interface GlossaryFacadeInterface {
    Map<String, String> getGlossaryTextMapByLanguage(String key);
    List<String> getAvailableLanguages();
}

package adminlte.web_form.communication.form_elements;

import java.util.Map;

public interface Localizable {
    String getGlossaryKey();

    WebFormElementInterface addLanguage(String language);

    Localizable setValue(Map<String, String> value);
}

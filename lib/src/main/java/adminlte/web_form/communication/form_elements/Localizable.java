package adminlte.web_form.communication.form_elements;

import java.util.Map;

public interface Localizable {
    String getGlossaryKey();
    Localizable setValue(Map<String, String> value);
}

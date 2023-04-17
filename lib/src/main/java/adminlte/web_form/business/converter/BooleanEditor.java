package adminlte.web_form.business.converter;

import org.thymeleaf.util.StringUtils;

import java.beans.PropertyEditorSupport;

public class BooleanEditor extends PropertyEditorSupport {

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        setValue(false);

        if (!StringUtils.isEmpty(text)) {
            if (text.equalsIgnoreCase("on")) {
                setValue(true);
            } else {
                setValue(Boolean.valueOf(text));
            }
        }
    }
}

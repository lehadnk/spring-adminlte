package adminlte.web_form.business.converter;

import org.thymeleaf.util.StringUtils;

import java.beans.PropertyEditorSupport;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoField;
import java.util.ArrayList;

public class LocalDateTimeEditor extends PropertyEditorSupport {

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        setValue(null);

        ArrayList<String> patterns = new ArrayList<>();
        patterns.add("yyyy-MM-dd'T'HH:mm:ss");
        patterns.add("yyyy-MM-dd'T'HH:mm");

        DateTimeParseException exception = null;

        if (!StringUtils.isEmpty(text)) {
            for (var pattern : patterns) {
                try {
                    DateTimeFormatter formatter = new DateTimeFormatterBuilder()
                        .appendPattern(pattern)
                        // optional decimal point followed by 1 to 6 digits
                        .optionalStart()
                        .appendFraction(ChronoField.MICRO_OF_SECOND, 1, 6, true)
                        .optionalEnd()
                        .toFormatter();

                    LocalDateTime dateTime = LocalDateTime.parse(text, formatter);
                    setValue(dateTime);

                    exception = null;
                    break;
                } catch (DateTimeParseException e) {
                    exception = e;
                }
            }

            if (exception != null) {
                throw new IllegalArgumentException(exception);
            }
        }
    }
}

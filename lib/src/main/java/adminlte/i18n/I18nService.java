package adminlte.i18n;

import adminlte.i18n.business.TranslatedStringFormatter;
import org.springframework.stereotype.Service;

@Service
public class I18nService {
    private final TranslatedStringFormatter translatedStringFormatter;

    public I18nService(
            TranslatedStringFormatter translatedStringFormatter
    ) {
        this.translatedStringFormatter = translatedStringFormatter;
    }

    public String formatString(String id, Object[] args)
    {
        return this.translatedStringFormatter.format(id, args);
    }

    public String formatString(String id)
    {
        return this.translatedStringFormatter.format(id, null);
    }
}

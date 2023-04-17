package adminlte.web_form;


import java.util.List;

public interface WebFormDependencyProviderInterface
{
    List<String> getAvailableLanguages();
    List<String> getAvailableLanguageCodes();
}

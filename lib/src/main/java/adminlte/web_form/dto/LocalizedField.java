package adminlte.web_form.dto;

public class LocalizedField {
    private String key;
    private LocalizationData localization;

    public String getKey()
    {
        return this.key;
    }

    public void setKey(String key)
    {
        this.key = key;
    }

    public LocalizationData getLocalization()
    {
        return this.localization;
    }
}

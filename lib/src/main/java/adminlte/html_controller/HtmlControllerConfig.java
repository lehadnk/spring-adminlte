package adminlte.html_controller;

import org.springframework.beans.factory.annotation.Value;

public class HtmlControllerConfig {
    @Value("${adminlte.navigation.title}")
    public String navigationMenuTitle;
}

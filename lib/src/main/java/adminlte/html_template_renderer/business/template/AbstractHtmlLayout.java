package adminlte.html_template_renderer.business.template;

abstract public class AbstractHtmlLayout extends AbstractHtmlTemplate {
    public void setContent(String content)
    {
        this.context.setVariable("content", content);
    }

    public AbstractHtmlLayout getLayoutTemplate() {
        return null;
    }
}

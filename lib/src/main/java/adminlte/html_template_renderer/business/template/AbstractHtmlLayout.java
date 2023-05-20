package adminlte.html_template_renderer.business.template;

abstract public class AbstractHtmlLayout extends AbstractHtmlTemplate {
    public void setContent(String content)
    {
        this.context.setVariable("content", content);
    }

    public void setProjectName(String projectName)
    {
        this.context.setVariable("projectName", projectName);
    }

    public void setPageTitle(String pageTitle)
    {
        this.context.setVariable("pageTitle", pageTitle);
    }

    public AbstractHtmlLayout getLayoutTemplate() {
        return null;
    }
}

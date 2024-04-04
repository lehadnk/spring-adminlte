# Configuration
1. Install the package by adding the following dependency in the dependecies section of your package manager (e.g. `build.gradle`):
```java
dependencies {
    implementation 'com.github.lehadnk:adminlte:1.6.0'
}
```
2. Configure the configuration bean inside your project:
```java
@Import({
        EntityListTableBeanConfiguration.class,
        HtmlControllerBeanConfiguration.class,
        HtmlTemplateRendererBeanConfiguration.class,
        NavigationMenuBeanConfiguration.class,
        WebFormBeanConfiguration.class,
        FlashMessageBeanConfiguration.class,
        I18nBeanConfiguration.class
})
@Configuration
public class BackofficeConfigurationBean {
}
```
3. Enter the following settings to your `application.yml`:
```yaml
adminlte:
  project-name: Swaraj Admin
  page-title: Swaraj Admin
  navigation:
    title: Swaraj Admin
```

# Basic usage
## Displaying a table
1. Define a table class:
```java
public class UsersTable extends AbstractTable<User> {
    public UsersTable(PaginatedEntityListInterface<User> entityPaginatedList) {
        super(entityPaginatedList);
    }

    @Override
    public String getTitle() {
        return "Users";
    }

    @Override
    public void defineColumns() {
        this.addColumn(new TextColumn("id").setTitle("Id"));
        this.addColumn(new TextColumn("name").setTitle("Name"));
        this.addColumn(new TextColumn("registered_at").setTitle("Registered At"));
        
        var actionButtons = List.of(
            new ActionButton("Confirm", "/admin/user-list/confirm/<:id>", "id", "btn-primary")
        );
        this.addColumn(new ActionsColumn(actionButtons).setTitle("Edit"));
    }
}
```
2. Render a table inside of your controller class:
```java
@Controller
public class UsersController extends AbstractHtmlController {
    private final UserDataProvider userDataProvider;

    public TableController(
            LayoutFactory layoutFactory,
            HtmlTemplateRendererService htmlTemplateRendererService,
            WebFormService webFormService,
            EntityListTableService entityListTableService,
            SessionServiceInterface sessionService,
            AuthenticationServiceInterface authenticationService,
            FlashMessageService flashMessageService,
            UserDataProvider userDataProvider
    ) {
        super(layoutFactory, htmlTemplateRendererService, webFormService, entityListTableService, sessionService, authenticationService, flashMessageService);
        this.userDataProvider = userDataProvider;
    }

    @GetMapping("/users")
    @ResponseBody
    public String renderTable(
            @RequestParam(value = "page", defaultValue = "1") int page
    ) {
        var userList = this.userDataProvider.getUsers(page, 20);
        var table = new UsersTable(userList);

        return this.renderTemplate(
                new AuthorizedAdminTableTemplate(
                        this.layoutFactory.createAuthorizedAdminLayout("Table"),
                        this.entityListTableService.renderTable(table)
                )
        );
    }
}
```

## Creating a form
1. Define a form class:
```java
public class SelectCitiesForm extends AbstractWebForm<SelectCitiesRequest> {
    public SelectCitiesForm() {
        var options = new HashMap<String, String>();
        options.put("1", "New York");
        options.put("2", "Los Angeles");
        options.put("3", "Chicago");
        options.put("4", "Houston");
        options.put("5", "Philadelphia");
        options.put("6", "Phoenix");

        this.elements.put("cities", new MultipleSelect(options));
        
        this.addSubmitButton(new Submit("Submit"));
    }
}
```
2. Display and handle the form in your controller:
```java
@Controller
public class MultiselectController extends AbstractHtmlController {
    public MultiselectController(
            LayoutFactory layoutFactory, 
            HtmlTemplateRendererService htmlTemplateRendererService, 
            WebFormService webFormService, 
            EntityListTableService entityListTableService, 
            SessionServiceInterface sessionService, 
            AuthenticationServiceInterface authenticationService, 
            FlashMessageService flashMessageService
    ) {
        super(layoutFactory, htmlTemplateRendererService, webFormService, entityListTableService, sessionService, authenticationService, flashMessageService);
    }

    @GetMapping("/select-city")
    @ResponseBody
    public String getForm() {
        // Create a form
        var form = new SelectCitiesForm();
        
        // This way we can inject the selected values inside the form (e.g. default values, or data read from DB in case of updating the existing DB record.
        var defaultValues = new SelectCitiesRequest();
        defaultValues.cities = List.of("1", "3");
        form.hydrateFromRequest(defaultValues);

        // Render the template
        return this.renderTemplate(
                new AuthorizedAdminFormTemplate(
                        this.layoutFactory.createAuthorizedAdminLayout("Multiselect"),
                        this.webFormService.renderForm(form)
                )
        );
    }

    @PostMapping("/select-city")
    @ResponseBody
    public String postForm(
            @ModelAttribute SelectCitiesRequest request
    ) {
        var form = new SelectCitiesForm();
        form.hydrateFromRequest(request);

        if (this.webFormService.isFormValid(form)) {
            // perform the save logic
        }

        return this.renderTemplate(
                new AuthorizedAdminFormTemplate(
                        this.layoutFactory.createAuthorizedAdminLayout("Multiselect"),
                        this.webFormService.renderForm(form)
                )
        );
    }
}

```

## Defining a custom template
Sometimes you may want to extend the default templates, or create a new one of your own. The package uses thymeleaf as the html renderer.

1. Define the thymeleaf html, e.g. `resources/news/communication/http/templates/html/news_item_list.html`:
```html
<div class="row">
    <div class="col-sm-3">
        <a class="btn btn-block btn-secondary mb-3" href="/admin/news/create">Create News</a>
    </div>
</div>
<div th:utext="${newsItemListTable}"></div>
```

2. Define the template definition class:
```java
public class NewsItemListTemplate extends AbstractAuthorizedAdminLayoutTemplate {
    final private String templatePath = "news/communication/http/templates/html/news_item_list.html";

    public NewsItemListTemplate(
            AuthorizedAdminLayout layout,
            String newsItemListTableContent
    ) {
        super(layout);
        this.context.setVariable("newsItemListTable", newsItemListTableContent);
    }

    @Override
    public String getTemplatePath() {
        return this.templatePath;
    }
}
```

3. Use the template inside your controller:
```java
    @GetMapping("/admin/news")
    @RequiresAdmin
    @ResponseBody
    public String getList(
            @RequestParam(value = "page", defaultValue = "1") Integer page
    ) {
        var pageable = PageRequest.of(page - 1, 10, Sort.by("id").descending());
        var newsList = this.newsService.getNewsList(pageable);

        var newsItemsTable = new NewsItemsTable(
                newsList
        );

        var newsItemListTemplate = new NewsItemListTemplate(
                this.layoutFactory.createAuthorizedAdminLayout("News List"),
                this.entityListTableService.renderTable(newsItemsTable),
                List.of(
                        new HrefButton("Create News", "/admin/news/create")
                )
        );

        return this.renderTemplate(newsItemListTemplate);
    }
```

## Handling navigation menu
Navigation menu shows inside the Authorized Admin Layout, and creates automatically based on menu items definition provided in your code. You have to implement `MenuItemsProviderInterface`, the spring autoloader will bootstrap everything automatically:
```java
@Component
public class DemoApplicationMenuItemsProvider implements MenuItemsProviderInterface {

    @Override
    public List<MenuItemInterface> getMenuItems() {
        var list = new ArrayList<MenuItemInterface>();
        list.add(new NavigationMenuItem().setTitle("Form Validation Errors").setUrl("/forms/validation-error"));
        list.add(new NavigationMenuItem().setTitle("Notifications").setUrl("/notifications"));
        list.add(new NavigationMenuItem().setTitle("Table").setUrl("/table"));
        list.add(new NavigationMenuItem().setTitle("Empty Table").setUrl("/table/empty"));
        list.add(new NavigationMenuItem().setTitle("World Map").setUrl("/world-map"));
        list.add(new NavigationMenuItem().setTitle("WYSIWYG").setUrl("/wysiwyg"));
        list.add(new NavigationMenuItem().setTitle("Multiselect").setUrl("/multiselect"));
        return list;
    }
}
```

# Publishing the dev build to local repository
 - Change version in build.gradle to dev
 - Add mavenLocal() to repositories
 - Use this publishing block: 
```
publishing {
    publications {
        mavenJava(MavenPublication) {
            from components.java
        }

    }
    repositories {
        mavenLocal()
    }
}
```

 - Run `./gradlew build && ./gradlew jar && ./gradlew publishToMavenLocal`

# Publishing to remote repository
`./gradlew clean sonatypeCentralUpload`
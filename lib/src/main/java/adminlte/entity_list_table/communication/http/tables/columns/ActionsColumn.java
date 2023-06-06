package adminlte.entity_list_table.communication.http.tables.columns;

import adminlte.entity_list_table.dto.CellActionButton;
import org.thymeleaf.context.Context;

import java.util.ArrayList;

public class ActionsColumn extends AbstractColumn {
    private String templatePath = "entity_list_table/columns/actions_column.html";
    private ArrayList<ActionButton> actionButtons;
    private ArrayList<PostActionButton> postActionButtons;

    public ActionsColumn(ArrayList<ActionButton> actionButtons) {
        super("actions");
        this.actionButtons = actionButtons;
    }

    @Override
    public String getTemplatePath() {
        return this.templatePath;
    }

    public Context prepareContext(Object object) {
        var ctx = new Context();
        ctx.setVariable("buttons", this.getCellActionButtons(object, ActionButton.class));
        ctx.setVariable("postButtons", this.getCellActionButtons(object, PostActionButton.class));
        return ctx;
    }


    private <T> ArrayList<CellActionButton> getCellActionButtons(Object object, Class<T> buttonClass) {
        var result = new ArrayList<CellActionButton>();
        for (var actionButton : this.actionButtons) {
            if (actionButton.getClass() != buttonClass) { continue; }
            var url = actionButton.url;
            for (var idField : actionButton.identifierFields) {
                var identifier = this.getObjectValue(object, idField).toString();
                if (identifier == null) {
                    continue;
                }
                url = url.replaceAll("<:" + idField + ">", identifier);
            }
            var cellActionButton = new CellActionButton(url, actionButton.text, actionButton.cssClass);
            result.add(cellActionButton);
        }
        return result;
    }
}

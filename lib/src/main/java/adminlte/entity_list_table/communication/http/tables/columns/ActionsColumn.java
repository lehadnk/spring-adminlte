package adminlte.entity_list_table.communication.http.tables.columns;

import adminlte.entity_list_table.dto.CellActionButton;
import org.thymeleaf.context.Context;

import java.util.ArrayList;

public class ActionsColumn extends AbstractColumn {
    private String templatePath = "entity_list_table/columns/actions_column.html";
    private ArrayList<ActionButton> actionButtons;

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
        ctx.setVariable("buttons", this.getCellActionButtons(object));
        return ctx;
    }


    private ArrayList<CellActionButton> getCellActionButtons(Object object) {
        var result = new ArrayList<CellActionButton>();
        for (var actionButton : this.actionButtons) {
            var url = actionButton.url;
            for (var idField : actionButton.identifierFields) {
                var identifier = this.getObjectValue(object, idField).toString();
                if (identifier == null) {
                    continue;
                }
                url = url.replaceAll("<:" + idField + ">", identifier);
            }
            var cellActionButton = new CellActionButton(url, actionButton.text, actionButton.cssClass, actionButton.method);
            result.add(cellActionButton);
        }
        return result;
    }
}

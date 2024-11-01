package adminlte.entity_list_table.communication.http.tables.columns;

import adminlte.entity_list_table.dto.CellActionButton;
import org.thymeleaf.context.Context;

import java.util.ArrayList;
import java.util.List;

public class ActionsColumn extends AbstractColumn {
    private String templatePath = "entity_list_table/columns/actions_column.html";
    private List<ActionButton> actionButtons;

    public ActionsColumn(List<ActionButton> actionButtons) {
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

    private List<CellActionButton> getCellActionButtons(Object object) {
        var result = new ArrayList<CellActionButton>();
        for (var actionButton : this.actionButtons) {
            var url = actionButton.url;
            for (var idField : actionButton.identifierFields) {
                var identifier = this.getObjectValue(object, idField);
                if (identifier == null) {
                    url = null;
                    break;
                }
                url = url.replaceAll("<:" + idField + ">", identifier.toString());
                url = url.replaceAll("{" + idField + "}", identifier.toString());
            }
            // Don't generate a button if any of the identifies is null, since it will be a
            // broken link either way.
            if (url != null) {
                var cellActionButton = new CellActionButton(url, actionButton.text, actionButton.cssClass,
                        actionButton.method);
                result.add(cellActionButton);
            }
        }
        return result;
    }
}

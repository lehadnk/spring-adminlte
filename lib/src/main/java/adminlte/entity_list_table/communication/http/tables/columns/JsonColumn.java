package adminlte.entity_list_table.communication.http.tables.columns;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.thymeleaf.context.Context;

public class JsonColumn extends TextColumn {

    private ObjectMapper objectMapper;

    // TODO: Support 
    public JsonColumn(String fieldName) {
        super(fieldName);
        objectMapper = new ObjectMapper();
        objectMapper.findAndRegisterModules();
    }

    @Override
    public String getCsvCellContent(Object object) {
        // TODO: Add filtering ?

        var content = this.getObjectValue(object, this.fieldName);

        if (content != null) {

            try {
                return objectMapper.writeValueAsString(content).replace("\"", "");
            } catch (JsonProcessingException e) {
                return "Failed to generate json";
            }
        }
        return "";
    }

    @Override
    public Context prepareContext(Object object) {
        var ctx = new Context();
        var content = this.getObjectValue(object, this.fieldName);

        if (content != null) {

            try {
                content = objectMapper.writeValueAsString(content).replace("\"", "");
            } catch (JsonProcessingException e) {
                content = "Failed to generate json";
            }
        }

        ctx.setVariable("content", content);
        return ctx;
    }
}

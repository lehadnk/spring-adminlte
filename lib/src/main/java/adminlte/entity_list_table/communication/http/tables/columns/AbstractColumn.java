package adminlte.entity_list_table.communication.http.tables.columns;

import java.lang.reflect.InvocationTargetException;

abstract public class AbstractColumn implements ColumnDefinitionInterface {
    private String title;
    protected String fieldName;

    public AbstractColumn(String fieldName) {
        this.fieldName = fieldName;
    }

    public ColumnDefinitionInterface setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getTitle() {
        return this.title;
    }

    public String getFieldName() {
        return this.fieldName;
    }

    public String getCsvCellContent(Object object) {
        return "";
    }

    protected Object getObjectValue(Object object, String fieldName) {
        var fieldParts = fieldName.split("\\.", 2);
        var topLevelFieldName = fieldParts[0];
        var lowLevelFieldName = fieldParts.length == 2 ? fieldParts[1] : null;

        if (object instanceof Record record) {
            return this.getRecordValue(record, fieldName);
        }

        Object fieldOutput;
        try {
            var isMethod = topLevelFieldName.endsWith("()");
            if (isMethod) {
                var methodName = topLevelFieldName.replace("()", "");
                var objectMethod = object.getClass().getMethod(methodName);
                fieldOutput = objectMethod.invoke(object);
            } else {
                var objectField = object.getClass().getField(topLevelFieldName);
                fieldOutput = objectField.get(object);
            }

            if (lowLevelFieldName != null) {
                return getObjectValue(fieldOutput, lowLevelFieldName);
            } else {
                return fieldOutput;
            }
        } catch (NoSuchFieldException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            return null;
        }
    }

    private Object getRecordValue(Record record, String fieldName) {
        for (var recordComponent : record.getClass().getRecordComponents()) {
            if (recordComponent.getName().equals(fieldName)) {
                try {
                    return recordComponent.getAccessor().invoke(record);
                } catch (IllegalAccessException | InvocationTargetException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return null;
    }
}

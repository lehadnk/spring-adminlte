package adminlte.entity_list_table.communication.http.tables.columns;

import java.lang.reflect.Field;
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

    protected Object getObjectValue(Object object, String fieldName) {
        var fieldParts = fieldName.split("\\.", 2);
        var topLevelFieldName = fieldParts[0];
        var lowLevelFieldName = fieldParts.length == 2 ? fieldParts[1] : null;

        if (object instanceof Record record) {
            return this.getRecordValue(record, fieldName);
        }

        // gets all class public fields. there is no simple way to get all inherited private fields
        try {
            Field dtoField = object.getClass().getField(topLevelFieldName);
            if (lowLevelFieldName != null) {
                var topLevelFieldObject = dtoField.get(object);

                return getObjectValue(topLevelFieldObject, lowLevelFieldName);
            } else {
                return dtoField.get(object);
            }
        } catch (NoSuchFieldException|IllegalAccessException e) {
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

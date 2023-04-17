package adminlte.entity_list_table.communication.http.tables.columns;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

abstract public class AbstractColumn implements IColumnDefinition {
    private String title;
    protected String fieldName;

    public AbstractColumn(String fieldName) {
        this.fieldName = fieldName;
    }

    public IColumnDefinition setTitle(String title) {
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
        if (object instanceof Record record) {
            return this.getRecordValue(record, fieldName);
        }
        Field[] dtoFields = object.getClass().getFields();
        for (Field field : dtoFields) {
            if (field.getName().equals(fieldName)) {
                try {
                    return field.get(object);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        return null;
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

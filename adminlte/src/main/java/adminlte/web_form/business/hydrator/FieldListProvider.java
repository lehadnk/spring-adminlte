package adminlte.web_form.business.hydrator;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FieldListProvider {
    public List<Field> getAllFields(Class<?> type) {
        if (type.isInterface() || type.isArray() || type.isEnum() || type.isEnum() || type.isRecord()) {
            return List.of();
        }

        if (type.getCanonicalName().equals("java.lang.Object")) {
            return List.of();
        }

        var fields = Arrays.asList(type.getDeclaredFields());
        var superclassFields = this.getAllFields(type.getSuperclass());

        var result = new ArrayList<Field>(superclassFields.size() + fields.size());
        result.addAll(fields);
        result.addAll(superclassFields);

        return result;
    }
}

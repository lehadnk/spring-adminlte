package adminlte.entity_list_table.communication.http.tables.columns;

import org.thymeleaf.context.Context;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

public class DateInterfaceTimeColumn extends AbstractColumnInterface {
    private boolean useLocalTime = false;
    private String templatePath = "entity_list_table/columns/date_time_column.html";
    private String format = null;
    public DateInterfaceTimeColumn(String fieldName) {
        super(fieldName);
    }

    public DateInterfaceTimeColumn(String fieldName, String format) {
        super(fieldName);
        this.format = format;
    }

    public DateInterfaceTimeColumn(String fieldName, String format, boolean useLocalTime) {
        super(fieldName);
        this.format = format;
        this.useLocalTime = useLocalTime;
    }

    public DateInterfaceTimeColumn(String fieldName, boolean useLocalTime) {
        super(fieldName);
        this.useLocalTime = useLocalTime;
    }

    @Override
    public String getTemplatePath() {
        return this.templatePath;
    }

    public Context prepareContext(Object object) {
        var ctx = new Context();
        ctx.setVariable("content", this.getInstant(object));
        ctx.setVariable("useLocalTime", this.useLocalTime);
        ctx.setVariable("formattedUtcDateTimeString", this.getFormattedUtcDateTimeString(object));
        return ctx;
    }

    private String getFormattedUtcDateTimeString(Object object) {
        var instantObject = this.getInstant(object);
        if (instantObject == null) {return null;}
        if (this.format == null) {return instantObject.toString();}

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(this.format).withZone(ZoneId.of("UTC"));
        return formatter.format(instantObject);
    }

    private Instant getInstant(Object object) {
        var content = this.getObjectValue(object, this.fieldName);

        if (content == null) {
            return null;
        }

        if (content instanceof Instant) {
            return (Instant) content;
        }

        // assuming that LocalDateTime stores UTC value
        if (content instanceof LocalDateTime) {
            return ((LocalDateTime) object).toInstant(ZoneOffset.UTC);
        }

        return (Instant) content;
    }
}

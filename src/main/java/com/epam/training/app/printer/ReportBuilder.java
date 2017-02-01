package com.epam.training.app.printer;

import com.epam.training.app.Field;
import com.epam.training.app.FieldParam;

import java.util.Map;

public class ReportBuilder {
    private static final int SEPARATOR_SIZE = 30;
    private Field field;
    private FieldParam fieldParam;
    private Map<Enum, Integer> groups;

    public ReportBuilder(Field field, FieldParam fieldParam, Map<Enum, Integer> groups) {
        this.field = field;
        this.fieldParam = fieldParam;
        this.groups = groups;
    }

    public String build() {
        StringBuilder builder = new StringBuilder();
        builder.append(systemName());
        builder.append(separator(SEPARATOR_SIZE));
        builder.append(printParam());
        builder.append(separator(SEPARATOR_SIZE));
        builder.append(printField());
        builder.append(separator(SEPARATOR_SIZE));
        builder.append(groupTitle());
        builder.append(printGroups());

        return builder.toString();
    }

    private String separator(int size) {
        StringBuilder builder = new StringBuilder();
        for (int dash = 0; dash < size; dash++) {
            builder.append("-");
        }
        builder.append("\n");
        return builder.toString();
    }

    private String printField() {
        StringBuilder builder = new StringBuilder();
        for (int length = 0; length < field.getLength(); length++) {
            for (int width = 0; width < field.getWidth(); width++) {
                builder.append(field.getCell(length, width));
            }
            builder.append("\n");
        }
        return builder.toString();
    }

    private String printGroups() {
        StringBuilder builder = new StringBuilder();
        for (Map.Entry<Enum, Integer> pair : groups.entrySet()) {
            builder.append(pair.getKey()).append(": ").append(pair.getValue()).append("\n");
        }
        return builder.toString();
    }

    private String printParam() {
        StringBuilder builder = new StringBuilder();
        builder.append("Length printField: ").append(fieldParam.getLength()).append("\n");
        builder.append("Width printField: ").append(fieldParam.getWidth()).append("\n");
        builder.append("Fill factor: ").append(fieldParam.getFill_factor()).append("\n");
        return builder.toString();
    }

    private String systemName() {
        return "EMERGENCY PREVENTION SYSTEM\n";
    }

    private String groupTitle() {
        return "Risk groups report:\n";
    }
}

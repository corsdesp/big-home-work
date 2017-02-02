package com.epam.training.app.information_output;

import com.epam.training.app.Field;
import com.epam.training.app.FieldParam;
import com.epam.training.app.Group;

import java.util.Map;

public class ReportBuilder {
    private static final int SEPARATOR_SIZE = 30;
    private Field field;
    private FieldParam fieldParam;
    private Map<Group, Integer> groups;

    public ReportBuilder(Field field, FieldParam fieldParam, Map<Group, Integer> groups) {
        this.field = field;
        this.fieldParam = fieldParam;
        this.groups = groups;
    }

    public String build() {
        StringBuilder builder = new StringBuilder();
        builder.append(systemName());
        builder.append(separator(SEPARATOR_SIZE));
        builder.append(param());
        builder.append(separator(SEPARATOR_SIZE));
        builder.append(field());
        builder.append(separator(SEPARATOR_SIZE));
        builder.append(groupTitle());
        builder.append(groups());

        return builder.toString();
    }

    private String separator(int size) {
        StringBuilder builder = new StringBuilder();
        for (int count = 0; count < size; count++) {
            builder.append("-");
        }
        builder.append("\n");
        return builder.toString();
    }

    private String field() {
        StringBuilder builder = new StringBuilder();
        for (int length = 0; length < field.getLength(); length++) {
            for (int width = 0; width < field.getWidth(); width++) {
                builder.append(field.getCell(length, width));
            }
            builder.append("\n");
        }
        return builder.toString();
    }

    private String groups() {
        StringBuilder builder = new StringBuilder();
        for (Map.Entry<Group, Integer> pair : groups.entrySet()) {
            Group group = pair.getKey();
            builder.append(group).append("(").append(group.getMin()).append("-")
                    .append(group.getMax()).append(")").append(": ")
                    .append(pair.getValue()).append("\n");
        }
        return builder.toString();
    }

    private String param() {
        StringBuilder builder = new StringBuilder();
        builder.append("Length field: ").append(fieldParam.getLength()).append("\n");
        builder.append("Width field: ").append(fieldParam.getWidth()).append("\n");
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

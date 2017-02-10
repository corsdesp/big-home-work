package com.epam.training.app;

import com.epam.training.app.model.CellStatus;
import com.epam.training.app.model.Group;
import com.epam.training.app.model.Sector;

import java.util.Map;

public class ReportMaker {
    private static final int SEPARATOR_SIZE = 30;
    private Sector sector;
    private InputParam fieldParam;
    private Map<Group, Integer> groups;

    public ReportMaker(Sector sector, InputParam fieldParam, Map<Group, Integer> groups) {
        this.sector = sector;
        this.fieldParam = fieldParam;
        this.groups = groups;
    }

    public String make() {
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
        StringBuilder stringBuilder = new StringBuilder();
        for (int length = 0; length < sector.getLength(); length++) {
            for (int width = 0; width < sector.getWidth(); width++) {
                if (sector.getCell(length, width).getStatus() == CellStatus.HUMAN) {
                    stringBuilder.append("|X|");
                } else {
                    stringBuilder.append(" - ");
                }
            }
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
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
        builder.append("Length sector: ").append(fieldParam.getLength()).append("\n");
        builder.append("Width sector: ").append(fieldParam.getWidth()).append("\n");
        builder.append("Fill factor: ").append(fieldParam.getFillFactor()).append("\n");
        return builder.toString();
    }

    private String systemName() {
        return "EMERGENCY PREVENTION SYSTEM\n";
    }

    private String groupTitle() {
        return "Risk groups report:\n";
    }
}

package com.epam.training.app.model;

public enum Group {
    NONE(1, 2),
    MINOR(3, 4),
    NORMAL(5, 7),
    MAJOR(8, 13),
    CRITICAL(14, 100);

    private int min;
    private int max;

    Group(int min, int max) {
        this.min = min;
        this.max = max;
    }

    public static Group identifyGroup(int count) {
        for (Group group : Group.values()) {
            if (count <= group.getMax() && count >= group.getMin()) {
                return group;
            }
        }
        return CRITICAL;
    }

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }
}

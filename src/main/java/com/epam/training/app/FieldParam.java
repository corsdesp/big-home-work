package com.epam.training.app;

public class FieldParam {
    private int length;
    private int width;
    private double fill_factor;

    public FieldParam(int length, int width, double fill_factor) {
        this.length = length;
        this.width = width;
        this.fill_factor = fill_factor;
    }

    public int getLength() {
        return length;
    }

    public int getWidth() {
        return width;
    }

    public double getFill_factor() {
        return fill_factor;
    }
}

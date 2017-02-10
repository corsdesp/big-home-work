package com.epam.training.app;

public class InputParam {
    private final int length;
    private final int width;
    private final double fillFactor;

    public InputParam(int length, int width, double fillFactor) {
        checkSize(length, width);
        checkFillFactor(fillFactor);

        this.length = length;
        this.width = width;
        this.fillFactor = fillFactor;
    }

    public int getLength() {
        return length;
    }

    public int getWidth() {
        return width;
    }

    public double getFillFactor() {
        return fillFactor;
    }

    private boolean checkSize(int length, int width) {
        if (length <= 0 || width <= 0) {
            throw new IllegalArgumentException();
        }
        return true;
    }

    private boolean checkFillFactor(double fillFactor) {
        if (fillFactor < 0.0 || fillFactor > 1.0) {
            throw new IllegalArgumentException();
        }
        return true;
    }
}

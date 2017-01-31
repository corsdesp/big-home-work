package com.epam.training.app;

public class Field {
    private int length;
    private int width;
    private Cell[][] matrix;

    public Field(int length, int width) {
        this.length = length;
        this.width = width;
        matrix = new Cell[length][width];
    }

    public int getLength() {
        return length;
    }

    public int getWidth() {
        return width;
    }

    public void setCell(Cell element, int length, int width) {
        matrix[length][width] = element;
    }

    public Cell getCell(int length, int width) {
        return matrix[length][width];
    }
}

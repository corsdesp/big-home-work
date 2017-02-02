package com.epam.training.app;

public class Field implements Cloneable {
    private int length;
    private int width;
    private Cell[][] matrix;

    public Field(FieldParam param) {
        length = param.getLength();
        width = param.getWidth();
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

    @Override
    protected Field clone() {
        try {
            return (Field) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }
}

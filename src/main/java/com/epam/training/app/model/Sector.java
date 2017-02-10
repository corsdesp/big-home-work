package com.epam.training.app.model;

public class Sector {
    private Cell[][] matrix;

    public Sector(int length, int width) {
        matrix = new Cell[length][width];
    }

    public Cell getCell(int posX, int posY) {
        if (!isOutsideBorder(posX, posY)) {
            return null;
        }
        return matrix[posX][posY];
    }

    public void setCell(Cell cell) {
        matrix[cell.getPosX()][cell.getPosY()] = cell;
    }

    public int getLength() {
        return matrix.length;
    }

    public int getWidth() {
        return matrix[0].length;
    }

    private boolean isOutsideBorder(int posX, int posY) {
        return posX >= 0 && posX < getLength() && posY >= 0 && posY < getWidth();
    }
}

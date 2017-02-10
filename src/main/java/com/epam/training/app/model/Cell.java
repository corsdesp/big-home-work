package com.epam.training.app.model;


public class Cell {
    private final CellStatus status;
    private final int posX;
    private final int posY;

    public Cell(int posX, int posY, CellStatus status) {
        this.posX = posX;
        this.posY = posY;
        this.status = status;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public CellStatus getStatus() {
        return status;
    }
}

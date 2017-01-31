package com.epam.training.app;

public class Cell {
    private int posX;
    private int posY;
    private boolean busy;
    private boolean checked;

    public Cell() {
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public boolean isBusy() {
        return busy;
    }

    public void setBusy(boolean busy) {
        this.busy = busy;

    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    @Override
    public String toString() {
        if (busy) {
            return "|X|";
        } else {
            return " - ";
        }
    }
}

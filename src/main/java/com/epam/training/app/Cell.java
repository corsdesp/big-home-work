package com.epam.training.app;

import com.epam.training.app.enum_data.CheckPos;
import com.epam.training.app.enum_data.Status;

public class Cell {
    private int posX;
    private int posY;
    private CheckPos checked;
    private Status status;

    public Cell() {
        status = Status.FREE;
        checked = CheckPos.NO;
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

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public CheckPos getChecked() {
        return checked;
    }

    public void setChecked(CheckPos checked) {
        this.checked = checked;
    }

    @Override
    public String toString() {
        if (status == Status.BUSY) {
            return "|X|";
        } else {
            return " - ";
        }
    }
}

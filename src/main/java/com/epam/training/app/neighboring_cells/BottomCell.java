package com.epam.training.app.neighboring_cells;

import com.epam.training.app.Cell;
import com.epam.training.app.Field;
import com.epam.training.app.status_enum.CheckPos;
import com.epam.training.app.status_enum.Status;

public class BottomCell implements NeighboringCells {
    private static final int STEP = 1;
    private Field field;

    public BottomCell(Field field) {
        this.field = field;
    }

    @Override
    public Cell checkCells(Cell cell) {
        int x = cell.getPosX();
        int y = cell.getPosY();

        if (y - 1 >= 0) {
            Cell cellBottom = field.getCell(x, y - STEP);
            if (checkStatus(cellBottom)) {
                positiveChecked(cellBottom, x, y - STEP);
                return cellBottom;
            }
        }
        return null;
    }


    private void positiveChecked(Cell cell, int length, int width) {
        cell.setChecked(CheckPos.YES);
        field.setCell(cell, length, width);
    }

    private boolean checkStatus(Cell cell) {
        return cell.getStatus() == Status.BUSY && cell.getChecked() == CheckPos.NO;
    }
}

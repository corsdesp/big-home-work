package com.epam.training.app.neighboring_cells;

import com.epam.training.app.Cell;
import com.epam.training.app.Field;
import com.epam.training.app.status_enum.CheckPos;
import com.epam.training.app.status_enum.Status;

public class RightCell implements NeighboringCells {
    private static final int STEP = 1;
    private Field field;

    public RightCell(Field field) {
        this.field = field;
    }

    @Override
    public Cell checkCells(Cell cell) {
        int x = cell.getPosX();
        int y = cell.getPosY();

        if (x + 1 < field.getLength()) {
            Cell cellRight = field.getCell(x + STEP, y);
            if (checkStatus(cellRight)) {
                positiveChecked(cellRight, x + STEP, y);
                return cellRight;
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

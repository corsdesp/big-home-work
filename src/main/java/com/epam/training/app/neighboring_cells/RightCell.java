package com.epam.training.app.neighboring_cells;

import com.epam.training.app.Cell;
import com.epam.training.app.field_data.Field;
import com.epam.training.app.enum_data.CheckPos;
import com.epam.training.app.enum_data.Status;

public class RightCell implements NeighboringCells {
    private Field field;

    public RightCell(Field field) {
        this.field = field;
    }

    @Override
    public Cell checkCells(Cell cell) {
        int x = cell.getPosX();
        int y = cell.getPosY();

        if (x + STEP < field.getLength()) {
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

package com.epam.training.app.neighboring_cells;

import com.epam.training.app.Cell;

public interface NeighboringCells {
    int STEP = 1;

    Cell checkCells(Cell cell);
}

package com.epam.training.app;

import com.epam.training.app.model.Cell;
import com.epam.training.app.model.CellStatus;
import com.epam.training.app.model.Sector;

public class Filler {
    public void fill(Sector sector, double fillFactor) {
        for (int length = 0; length < sector.getLength(); length++) {
            for (int width = 0; width < sector.getWidth(); width++) {
                sector.setCell(new Cell(length, width, CellStatus.FREE));
            }
        }

        int count = (int) (sector.getLength() * sector.getWidth() * fillFactor);
        for (int i = 0; i < count; ) {
            int randomPosX = (int) (Math.random() * sector.getLength());
            int randomPosY = (int) (Math.random() * sector.getWidth());

            Cell cell = sector.getCell(randomPosX, randomPosY);

            if (cell.getStatus() == CellStatus.FREE) {
                sector.setCell(new Cell(randomPosX, randomPosY, CellStatus.HUMAN));
                i++;
            }
        }
    }
}

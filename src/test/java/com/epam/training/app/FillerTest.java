package com.epam.training.app;

import com.epam.training.app.model.Sector;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class FillerTest {
    @Test
    public void fillWhenRandomZero() throws Exception {
        InputParam param = new InputParam(4, 4, 0.0);

        Sector firstSector = new Sector(param.getLength(), param.getWidth());
        Sector secondSector = new Sector(param.getLength(), param.getWidth());

        new Filler().fill(firstSector, param.getFillFactor());
        new Filler().fill(secondSector, param.getFillFactor());

        Assert.assertTrue(Arrays.deepEquals(getSectorMatrix(firstSector), getSectorMatrix(secondSector)));
    }

    @Test
    public void fillWhenRandomOne() throws Exception {
        InputParam param = new InputParam(4, 4, 1.0);

        Sector firstSector = new Sector(param.getLength(), param.getWidth());
        Sector secondSector = new Sector(param.getLength(), param.getWidth());

        new Filler().fill(firstSector, param.getFillFactor());
        new Filler().fill(secondSector, param.getFillFactor());

        Assert.assertTrue(Arrays.deepEquals(getSectorMatrix(firstSector), getSectorMatrix(secondSector)));
    }


    private String[][] getSectorMatrix(Sector sector) {
        String[][] array = new String[sector.getLength()][sector.getWidth()];
        for (int length = 0; length < sector.getLength(); length++) {
            for (int width = 0; width < sector.getWidth(); width++) {
                array[length][width] = sector.getCell(length, width).getStatus().name();
            }
        }
        return array;
    }
}

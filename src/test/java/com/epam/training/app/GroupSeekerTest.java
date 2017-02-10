package com.epam.training.app;

import com.epam.training.app.model.Cell;
import com.epam.training.app.model.CellStatus;
import com.epam.training.app.model.Group;
import com.epam.training.app.model.Sector;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class GroupSeekerTest {
    @Test
    public void seekGroups() throws Exception {
        String[][] arraySector = {
                {"X", "-", "X", "X", "-", "X"},
                {"X", "-", "X", "X", "-", "-"},
                {"X", "X", "-", "-", "-", "-"},
                {"X", "-", "-", "X", "X", "-"},
                {"X", "-", "-", "-", "-", "-"}
        };

        Sector sector = convertArrayToSector(arraySector);
        Map<Group, Integer> foundGroups = new GroupSeeker(sector).seekGroups();

        Map<Group, Integer> standardResult = new LinkedHashMap<>();
        standardResult.put(Group.NONE, 2);
        standardResult.put(Group.MINOR, 1);
        standardResult.put(Group.NORMAL, 1);
        standardResult.put(Group.MAJOR, 0);
        standardResult.put(Group.CRITICAL, 0);

        Assert.assertTrue(Arrays.deepEquals(foundGroups.keySet().toArray(), standardResult.keySet().toArray()) &&
                Arrays.equals(foundGroups.entrySet().toArray(), standardResult.entrySet().toArray()));
    }

    private Sector convertArrayToSector(String[][] array) {
        Sector sector = new Sector(array.length, array[0].length);
        for (int width = 0; width < array[0].length; width++) {
            for (int length = 0; length < array.length; length++) {
                String value = array[length][width];
                CellStatus status;
                if (value.equals("X")) {
                    status = CellStatus.HUMAN;
                } else {
                    status = CellStatus.FREE;
                }
                sector.setCell(new Cell(length, width, status));
            }
        }
        return sector;
    }
}

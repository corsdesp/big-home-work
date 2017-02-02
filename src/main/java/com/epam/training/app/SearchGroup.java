package com.epam.training.app;

import com.epam.training.app.neighboring_cells.*;
import com.epam.training.app.status_enum.CheckPos;
import com.epam.training.app.status_enum.Status;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class SearchGroup {
    private Field field;

    public SearchGroup(Field field) {
        this.field = field.clone();
    }

    public Map<Group, Integer> search() {
        Map<Group, Integer> mapGroups = new LinkedHashMap<>();
        for (Group group : Group.values()) {
            mapGroups.put(group, 0);
        }

        for (int width = 0; width < field.getWidth(); width++) {
            for (int length = 0; length < field.getLength(); length++) {
                Cell cell = field.getCell(length, width);
                int count = 0;

                List<Cell> mainList = new ArrayList<>();
                if (cell.getStatus() == Status.BUSY && cell.getChecked() == CheckPos.NO) {
                    positiveChecked(cell, length, width);
                    mainList.add(cell);
                    while (mainList.size() > 0) {
                        List<Cell> neighboringCells = new ArrayList<>();
                        for (int i = 0; i < mainList.size(); i++) {
                            neighboringCells.addAll(checkCell(mainList.get(i)));
                            count++;
                        }
                        mainList.clear();
                        mainList.addAll(neighboringCells);
                    }
                    Group group = Group.identifyGroup(count);
                    int countGroup = mapGroups.get(group);
                    mapGroups.put(group, ++countGroup);
                }
            }
        }
        return mapGroups;
    }

    private List<Cell> checkCell(Cell cell) {
        List<Cell> list = new ArrayList<>();

        List<NeighboringCells> neighboringCellsList = new ArrayList<>();
        neighboringCellsList.add(new LeftCell(field));
        neighboringCellsList.add(new RightCell(field));
        neighboringCellsList.add(new TopCell(field));
        neighboringCellsList.add(new BottomCell(field));

        for (NeighboringCells nc : neighboringCellsList) {
            Cell neighborCell = nc.checkCells(cell);
            if (neighborCell != null) {
                list.add(neighborCell);
            }
        }
        return list;
    }

    private void positiveChecked(Cell cell, int length, int width) {
        cell.setChecked(CheckPos.YES);
        field.setCell(cell, length, width);
    }
}

package com.epam.training.app;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class SearchGroup {
    private static final int STEP = 1;
    private Field field;

    public SearchGroup(Field field) {
        this.field = field;
    }

    public Map<Enum, Integer> search() {
        Map<Enum, Integer> mapGroups = new LinkedHashMap<>();
        for (Group group : Group.values()) {
            mapGroups.put(group, 0);
        }

        for (int width = 0; width < field.getWidth(); width++) {
            for (int length = 0; length < field.getLength(); length++) {
                Cell cell = field.getCell(length, width);
                int count = 0;

                List<Cell> mainList = new ArrayList<>();
                if (cell.isBusy() && !cell.isChecked()) {
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

        Cell cellLeft = checkLeft(cell);
        if (cellLeft != null) {
            list.add(cellLeft);
        }
        Cell cellRight = checkRight(cell);
        if (cellRight != null) {
            list.add(cellRight);
        }
        Cell cellTop = checkTop(cell);
        if (cellTop != null) {
            list.add(cellTop);
        }
        Cell cellBottom = checkBottom(cell);
        if (cellBottom != null) {
            list.add(cellBottom);
        }
        return list;
    }

    private Cell checkLeft(Cell cell) {
        int x = cell.getPosX();
        int y = cell.getPosY();

        if (x - 1 >= 0) {
            Cell cellLeft = field.getCell(x - STEP, y);
            if (checkBool(cellLeft)) {
                positiveChecked(cellLeft, x - STEP, y);
                return cellLeft;
            }
        }
        return null;
    }

    private Cell checkRight(Cell cell) {
        int x = cell.getPosX();
        int y = cell.getPosY();

        if (x + 1 < field.getLength()) {
            Cell cellRight = field.getCell(x + STEP, y);
            if (checkBool(cellRight)) {
                positiveChecked(cellRight, x + STEP, y);
                return cellRight;
            }
        }
        return null;
    }

    private Cell checkTop(Cell cell) {
        int x = cell.getPosX();
        int y = cell.getPosY();

        if (y + 1 < field.getWidth()) {
            Cell cellTop = field.getCell(x, y + STEP);
            if (checkBool(cellTop)) {
                positiveChecked(cellTop, x, y + STEP);
                return cellTop;
            }
        }
        return null;
    }

    private Cell checkBottom(Cell cell) {
        int x = cell.getPosX();
        int y = cell.getPosY();

        if (y - 1 >= 0) {
            Cell cellBottom = field.getCell(x, y - STEP);
            if (checkBool(cellBottom)) {
                positiveChecked(cellBottom, x, y - STEP);
                return cellBottom;
            }
        }
        return null;
    }

    private void positiveChecked(Cell cell, int length, int width) {
        cell.setChecked(true);
        field.setCell(cell, length, width);
    }

    private boolean checkBool(Cell cell) {
        return cell.isBusy() && !cell.isChecked();
    }
}

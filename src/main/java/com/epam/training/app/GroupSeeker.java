package com.epam.training.app;

import com.epam.training.app.model.Cell;
import com.epam.training.app.model.CellStatus;
import com.epam.training.app.model.Group;
import com.epam.training.app.model.Sector;

import java.util.*;


public class GroupSeeker {
    private Sector sector;
    private SectorCellCheck sectorCellCheck;

    public GroupSeeker(Sector sector) {
        this.sector = sector;
    }

    public Map<Group, Integer> seekGroups() {
        sectorCellCheck = new SectorCellCheck(sector.getLength(), sector.getLength());

        Map<Group, Integer> retGroups = new LinkedHashMap<>();
        for (Group group : Group.values()) {
            retGroups.put(group, 0);
        }

        List<Integer> countIntoGroups = calcCountIntoGroup();
        for (Integer count : countIntoGroups) {
            Group group = Group.identifyGroup(count);
            int countGroup = retGroups.get(group);
            retGroups.put(group, ++countGroup);
        }
        return retGroups;
    }

    private List<Integer> calcCountIntoGroup() {
        List<Integer> countIntoGroups = new ArrayList<>();
        for (int length = 0; length < sector.getLength(); length++) {
            for (int width = 0; width < sector.getWidth(); width++) {
                Cell cell = sector.getCell(length, width);
                if (cell != null && !sectorCellCheck.isChecked(cell) && cell.getStatus() == CellStatus.HUMAN) {
                    countIntoGroups.add(calcNeighbors(cell));
                }
            }
        }
        return countIntoGroups;
    }

    private int calcNeighbors(Cell cell) {
        int count = 0;
        Deque<Cell> neighbors = new ArrayDeque<>();
        sectorCellCheck.setCheck(cell);
        neighbors.offer(cell);
        Cell studyCell;
        while ((studyCell = neighbors.poll()) != null) {
            count++;
            List<Cell> allNeighbors = getNeighbors(studyCell);
            for (Cell oneNeighbor : allNeighbors) {
                if (!sectorCellCheck.isChecked(oneNeighbor)) {
                    sectorCellCheck.setCheck(oneNeighbor);
                    neighbors.offer(oneNeighbor);
                }
            }
        }
        return count;
    }

    private List<Cell> getNeighbors(Cell cell) {
        List<Cell> neighbors = new ArrayList<>();
        neighbors.add(sector.getCell(cell.getPosX() - 1, cell.getPosY()));
        neighbors.add(sector.getCell(cell.getPosX() + 1, cell.getPosY()));
        neighbors.add(sector.getCell(cell.getPosX(), cell.getPosY() - 1));
        neighbors.add(sector.getCell(cell.getPosX(), cell.getPosY() + 1));

        List<Cell> returnNeighbors = new ArrayList<>();
        for (Cell unknownNeighbor : neighbors) {
            if (unknownNeighbor != null && unknownNeighbor.getStatus() == CellStatus.HUMAN) {
                returnNeighbors.add(unknownNeighbor);
            }
        }
        return returnNeighbors;
    }
}

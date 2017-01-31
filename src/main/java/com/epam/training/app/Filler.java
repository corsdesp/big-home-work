package com.epam.training.app;

public class Filler {
    public static void fill(Field field, double fill_factor) {
        for (int lengthField = 0; lengthField < field.getLength(); lengthField++) {
            for (int widthField = 0; widthField < field.getWidth(); widthField++) {
                Cell cell = new Cell();
                field.setCell(cell, lengthField, widthField);
            }
        }

        int count = (int) (field.getLength() * field.getWidth() * fill_factor);
        for (int i = 0; i < count; ) {
            int randomLength = (int) (Math.random() * field.getLength());
            int randomWidth = (int) (Math.random() * field.getWidth());

            Cell cell = field.getCell(randomLength, randomWidth);
            while (!cell.isBusy()) {
                cell.setBusy(true);
                cell.setPosX(randomLength);
                cell.setPosY(randomWidth);
                i++;
            }
        }
    }
}

package com.epam.training.app.field_data;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class FillerTest {
    @Test
    public void fillRandom() throws Exception {
        FieldParam param = new FieldParam(5, 5, 0.3);

        Field firstField = new Field(param);
        Field secondField = new Field(param);

        Filler.fill(firstField, param.getFill_factor());
        Filler.fill(secondField, param.getFill_factor());

        String[][] firstList = getFieldMatrix(firstField);
        String[][] secondList = getFieldMatrix(secondField);

        Assert.assertFalse(Arrays.deepEquals(firstList, secondList));
    }

    @Test
    public void fillWhenNotRandom() throws Exception {
        FieldParam param = new FieldParam(5, 5, 1);

        Field firstField = new Field(param);
        Field secondField = new Field(param);

        Filler.fill(firstField, param.getFill_factor());
        Filler.fill(secondField, param.getFill_factor());

        String[][] firstArray = getFieldMatrix(firstField);
        String[][] secondArray = getFieldMatrix(secondField);

        Assert.assertTrue(Arrays.deepEquals(firstArray, secondArray));
    }


    private String[][] getFieldMatrix(Field field) {
        String[][] array = new String[field.getLength()][field.getWidth()];
        for (int length = 0; length < field.getLength(); length++) {
            for (int width = 0; width < field.getWidth(); width++) {
                array[length][width] = field.getCell(length, width).toString();
            }
        }
        return array;
    }
}
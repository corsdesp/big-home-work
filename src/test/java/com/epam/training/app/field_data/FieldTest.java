package com.epam.training.app.field_data;

import org.junit.Assert;
import org.junit.Test;

public class FieldTest {
    @Test
    public void cloneTest() throws Exception {
        FieldParam param = new FieldParam(3, 3, 0.3);
        Field firstField = new Field(param);
        Field cloneField = firstField.clone();

        Assert.assertNotEquals(firstField, cloneField);
    }

}

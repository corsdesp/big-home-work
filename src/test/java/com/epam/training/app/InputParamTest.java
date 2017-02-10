package com.epam.training.app;

import org.junit.Test;

public class InputParamTest {
    @Test(expected = IllegalArgumentException.class)
    public void incorrectLengthInputParam() throws Exception {
        InputParam param = new InputParam(-4, 2, 0.1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void incorrectLengthWidthInputParam() throws Exception {
        InputParam param = new InputParam(-4, -2, 0.1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void incorrectWidthInputParam() throws Exception {
        InputParam param = new InputParam(4, -2, 0.1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void incorrectNegativeFillFactorInputParam() throws Exception {
        InputParam param = new InputParam(4, 2, -0.1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void incorrectFillFactorInputParam() throws Exception {
        InputParam param = new InputParam(4, 2, 1.1);
    }
}

package com.epam.training.app;

import org.apache.commons.cli.ParseException;
import org.junit.Assert;
import org.junit.Test;


public class ParserTest {
    @Test
    public void parseNormalOrderArgs() throws Exception {
        String[] args = {"-x", "4", "-y", "5", "-ff", "0.3"};
        Parser parser = new Parser();
        InputParam param = parser.parse(args);

        Assert.assertTrue(args[1].equals(String.valueOf(param.getLength())));
        Assert.assertTrue(args[3].equals(String.valueOf(param.getWidth())));
        Assert.assertTrue(args[5].equals(String.valueOf(param.getFillFactor())));
    }

    @Test
    public void parseConfusedOrderArgs() throws Exception {
        String[] args = {"-y", "2", "-ff", "0.9", "-x", "3"};
        Parser parser = new Parser();
        InputParam param = parser.parse(args);

        Assert.assertTrue(args[5].equals(String.valueOf(param.getLength())));
        Assert.assertTrue(args[1].equals(String.valueOf(param.getWidth())));
        Assert.assertTrue(args[3].equals(String.valueOf(param.getFillFactor())));
    }

    @Test(expected = ParseException.class)
    public void parseIncorrectArgs() throws Exception {
        String[] args = {"-t", "0", "- f", "2", "x-", "-13"};
        Parser parser = new Parser();
        InputParam param = parser.parse(args);
    }
}

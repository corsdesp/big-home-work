package com.epam.training.app;

import org.apache.commons.cli.*;

public class Parser {
    private Options options = new Options();

    public Parser() {
    }

    public InputParam parse(String[] args) throws ParseException {
        CommandLineParser parser = new DefaultParser();

        prepareOptions();

        CommandLine cmd = parser.parse(options, args);
        int length = Integer.parseInt(cmd.getOptionValue("x"));
        int width = Integer.parseInt(cmd.getOptionValue("y"));
        double fillFactor = Double.parseDouble(cmd.getOptionValue("ff"));

        return new InputParam(length, width, fillFactor);
    }

    public void help() {
        HelpFormatter formatter = new HelpFormatter();
        formatter.setOptionComparator(null);
        formatter.printHelp("application", options, true);
    }

    private void prepareOptions() {
        options.addOption("x", "length", true, "length field");
        options.addOption("y", "width", true, "width field");
        options.addOption("ff", "fill factor", true, "fill factor field");
    }
}

package com.epam.training.app;

import org.apache.commons.cli.*;

public class ConsoleCli {
    private String[] args;
    private Options options = new Options();
    private CommandLine cmd = null;

    public ConsoleCli(String[] args) {
        this.args = args;

        options.addOption("l", "length", true, "length field");
        options.addOption("w", "width", true, "width field");
        options.addOption("ff", "fill factor", true, "fill factor field");
    }

    public FieldParam parse() {
        CommandLineParser parser = new DefaultParser();
        try {
            cmd = parser.parse(options, args);
        } catch (ParseException e) {
            help();
        }
        int length = Integer.parseInt(cmd.getOptionValue("l"));
        int width = Integer.parseInt(cmd.getOptionValue("w"));
        double fill_factor = Double.parseDouble(cmd.getOptionValue("ff"));

        return new FieldParam(length, width, fill_factor);
    }

    private void help() {
        HelpFormatter formatter = new HelpFormatter();
        formatter.setOptionComparator(null);
        formatter.printHelp("application", options, true);
    }
}


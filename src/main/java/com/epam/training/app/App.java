package com.epam.training.app;

import java.util.Map;

public class App {
    public static void main(String[] args) {
        ConsoleCli consoleCli = new ConsoleCli(args);
        FieldParam parameters = consoleCli.parse();

        Field field = new Field(parameters.getLength(), parameters.getWidth());
        Filler.fill(field, parameters.getFill_factor());

        SearchGroup searchGroup = new SearchGroup(field);
        Map<Enum, Integer> groups = searchGroup.search();

        Printer printer = new Printer(field, parameters, groups);
        printer.print();
    }
}

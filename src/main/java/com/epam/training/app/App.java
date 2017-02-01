package com.epam.training.app;

import com.epam.training.app.printer.ConsolePrinter;
import com.epam.training.app.printer.Printer;
import com.epam.training.app.printer.ReportBuilder;

import java.util.Map;

public class App {
    public static void main(String[] args) {
        ConsoleCli consoleCli = new ConsoleCli(args);
        FieldParam parameters = consoleCli.parse();

        Field field = new Field(parameters.getLength(), parameters.getWidth());
        Filler.fill(field, parameters.getFill_factor());

        SearchGroup searchGroup = new SearchGroup(field);
        Map<Enum, Integer> groups = searchGroup.search();

        ReportBuilder reportBuilder = new ReportBuilder(field, parameters, groups);
        String report = reportBuilder.build();

        Printer printer = new ConsolePrinter();
        printer.print(report);
    }
}

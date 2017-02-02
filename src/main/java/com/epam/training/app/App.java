package com.epam.training.app;

import com.epam.training.app.enum_data.Group;
import com.epam.training.app.field_data.Field;
import com.epam.training.app.field_data.FieldParam;
import com.epam.training.app.field_data.Filler;
import com.epam.training.app.information_output.ConsolePrinter;
import com.epam.training.app.information_output.Printer;
import com.epam.training.app.information_output.ReportBuilder;

import java.util.Map;

public class App {
    public static void main(String[] args) {
        ConsoleCli consoleCli = new ConsoleCli(args);
        FieldParam parameters = consoleCli.parse();

        Field field = new Field(parameters);
        Filler.fill(field, parameters.getFill_factor());

        SearchGroup searchGroup = new SearchGroup(field);
        Map<Group, Integer> groups = searchGroup.search();

        ReportBuilder reportBuilder = new ReportBuilder(field, parameters, groups);
        String report = reportBuilder.build();

        Printer printer = new ConsolePrinter();
        printer.print(report);
    }
}

package com.epam.training.app;

import com.epam.training.app.model.Sector;
import org.apache.commons.cli.ParseException;

public class App {
    public static void main(String[] args) {
        Parser parser = new Parser();

        InputParam inputParam = null;
        try {
            inputParam = parser.parse(args);
        } catch (ParseException e) {
            parser.help();
        }

        Sector sector = new Sector(inputParam.getLength(), inputParam.getWidth());

        new Filler().fill(sector, inputParam.getFillFactor());

        GroupSeeker groupSeeker = new GroupSeeker(sector);

        ReportMaker reportMaker = new ReportMaker(sector, inputParam, groupSeeker.seekGroups());
        System.out.println(reportMaker.make());
    }
}

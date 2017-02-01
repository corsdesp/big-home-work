package com.epam.training.app.printer;

public class ConsolePrinter implements Printer{
    @Override
    public void print(String str) {
        System.out.println(str);
    }
}

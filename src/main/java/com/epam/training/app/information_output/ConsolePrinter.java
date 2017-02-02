package com.epam.training.app.information_output;

public class ConsolePrinter implements Printer{
    @Override
    public void print(String str) {
        System.out.println(str);
    }
}

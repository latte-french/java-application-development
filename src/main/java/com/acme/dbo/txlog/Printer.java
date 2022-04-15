package com.acme.dbo.txlog;

import static com.acme.dbo.txlog.Decorator.*;

public class Printer {

    public static void printDecoratedNumber(int message) {
        System.out.println(decorateNumber(message));
    }

    public static void printDecoratedChar(char message) {
        System.out.println(decorateChar(message));
    }

    public static void printDecoratedString(String message) {
        System.out.println(decorateString(message));
    }

    public static void printDecoratedBoolean(Boolean message) {
        System.out.println(decorateBoolean(message));
    }

    public static void printDecoratedObject(Object message) {
        System.out.println(decorateObject(message));
    }
}

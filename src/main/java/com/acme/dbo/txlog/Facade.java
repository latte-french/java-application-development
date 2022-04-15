package com.acme.dbo.txlog;

import static com.acme.dbo.txlog.Printer.*;

public class Facade {

    public static void log(int message) {
        printDecoratedNumber(message);
    }

    public static void log(byte message) {
        printDecoratedNumber(message);
    }

    public static void log(char message) {
        printDecoratedChar(message);
    }

    public static void log(String message) {
        printDecoratedString(message);
    }

    public static void log(Boolean message) {
        printDecoratedBoolean(message);
    }

    public static void log(Object message) {
        printDecoratedObject(message);
    }
}

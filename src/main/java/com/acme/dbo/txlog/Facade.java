package com.acme.dbo.txlog;

import static com.acme.dbo.txlog.ConsoleSaver.*;
import static com.acme.dbo.txlog.Decorator.decorateMessage;

public class Facade {

    private static int intAccumulator = 0;
    private static boolean intAccumulationStarted = false;
    private static int stringAccumulator = 0;
    private static String accumulatedString = "";
    private static boolean stringAccumulationStarted = false;

    public static void log(int message) {
        if (stringAccumulationStarted)
            flush();
        intAccumulator += message;
        intAccumulationStarted = true;
    }

    public static void log(byte message) {
        saveDecoratedMessage(message);
    }

    public static void log(char message) {
        saveDecoratedMessage(message);
    }

    public static void log(String message) {
        if ((intAccumulationStarted) || (!accumulatedString.equals(message) && stringAccumulationStarted))
            flush();
        accumulateString(message);
    }

    public static void log(boolean message) {
        saveDecoratedMessage(message);
    }

    public static void log(Object message) {
        saveDecoratedMessage(message);
    }

    public static void flush() {
        if (intAccumulationStarted)
                flushInt();
        else flushString();;
    }

    private static void flushInt(){
        saveDecoratedMessage(intAccumulator);
        intAccumulator = 0;
        intAccumulationStarted = false;
    }
    private static void flushString(){
        String stringWithCount = stringAccumulator == 1? accumulatedString : accumulatedString + " (x" + stringAccumulator + ")";
        saveDecoratedMessage(stringWithCount);;
        accumulatedString = "";
        stringAccumulator = 0;
        stringAccumulationStarted = false;
    }

    private static void accumulateString(String message) {
        accumulatedString = message;
        stringAccumulator++;
        stringAccumulationStarted = true;
    }
}

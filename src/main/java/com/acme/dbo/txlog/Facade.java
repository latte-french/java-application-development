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
        accumulateInteger(message);
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
        dropIntegerAccumulator();
    }
    private static void flushString(){
        String stringWithCount = stringAccumulator == 1? accumulatedString : accumulatedString + " (x" + stringAccumulator + ")";
        saveDecoratedMessage(stringWithCount);;
        dropStringAccumulator();
    }

    private static void accumulateInteger(int message) {
        modifyIntegerAccumulatorParameters(message, true);
    }

    private static void dropIntegerAccumulator(){
        modifyIntegerAccumulatorParameters(0, false);
    }

    private static void accumulateString(String message) {
        modifyStringAccumulatorParameters(message, true);
    }

    private static void dropStringAccumulator() {
        modifyStringAccumulatorParameters("", false);
    }

    private static void modifyIntegerAccumulatorParameters(int message, boolean accumulationStarted) {
        intAccumulationStarted = accumulationStarted;
        if (accumulationStarted)
            intAccumulator += message;
        else
            intAccumulator = message;
    }
    private static void modifyStringAccumulatorParameters(String message, boolean accumulationStarted) {
        accumulatedString = message;
        stringAccumulationStarted = accumulationStarted;
        if (accumulationStarted)
            stringAccumulator++;
        else
            stringAccumulator = 0;
    }
}

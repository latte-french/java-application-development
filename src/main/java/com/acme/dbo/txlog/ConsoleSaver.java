package com.acme.dbo.txlog;

import static com.acme.dbo.txlog.Decorator.*;

public class ConsoleSaver {
    private static int intAccumulator = 0;
    private static boolean intAccumulationStarted = false;
    private static int stringAccumulator = 0;
    private static String accumulatedString = "";
    private static boolean stringAccumulationStarted = false;

    public static void saveDecoratedMessage(int message) {
        if (stringAccumulationStarted)
            flushString();
        intAccumulator += message;
        intAccumulationStarted = true;
    }

    public static void saveDecoratedMessage(byte message) {
        System.out.println(decorateMessage(message));
    }

    public static void saveDecoratedMessage(char message) {
        System.out.println(decorateMessage(message));
    }

    public static void saveDecoratedMessage(String message) {
        if (intAccumulationStarted)
            flushInt();
        if (!accumulatedString.equals(message) && stringAccumulationStarted)
            flushString();
        accumulateString(message);
    }

    public static void saveDecoratedMessage(boolean message) {
        System.out.println(decorateMessage(message));
    }

    public static void saveDecoratedMessage(Object message) {
        System.out.println(decorateMessage(message));
    }
    public static void flushInt(){
        System.out.println(decorateMessage(intAccumulator));
        intAccumulator = 0;
        intAccumulationStarted = false;
    }
    public static void flushString(){
        if (stringAccumulator == 1) {
            System.out.println(decorateMessage(accumulatedString));
        }
        else {
            System.out.println(decorateMessage(accumulatedString + " (x" + stringAccumulator + ")"));
        }
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

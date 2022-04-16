package com.acme.dbo.txlog;

import static com.acme.dbo.txlog.ConsoleSaver.*;

public class Facade {

    public static void log(int message) {
        saveDecoratedMessage(message);
    }

    public static void log(byte message) {
        saveDecoratedMessage(message);
    }

    public static void log(char message) {
        saveDecoratedMessage(message);
    }

    public static void log(String message) {
        saveDecoratedMessage(message);
    }

    public static void log(boolean message) {
        saveDecoratedMessage(message);
    }

    public static void log(Object message) {
        saveDecoratedMessage(message);
    }
}

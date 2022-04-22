package com.acme.dbo.txlog;

import static com.acme.dbo.txlog.Decorator.*;

public class ConsoleSaver {

    public static void saveDecoratedMessage(int message) {
        System.out.println(decorateMessage(message));
    }

    public static void saveDecoratedMessage(byte message) {
        System.out.println(decorateMessage(message));
    }

    public static void saveDecoratedMessage(char message) {
        System.out.println(decorateMessage(message));
    }

    public static void saveDecoratedMessage(String message) {
        System.out.println(decorateMessage(message));
    }

    public static void saveDecoratedMessage(boolean message) {
        System.out.println(decorateMessage(message));
    }

    public static void saveDecoratedMessage(Object message) {
        System.out.println(decorateMessage(message));
    }
}

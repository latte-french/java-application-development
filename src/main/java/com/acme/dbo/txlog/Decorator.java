package com.acme.dbo.txlog;

public class Decorator {

    private static final String PRIMITIVE_PREFIX = "primitive: ";
    private static final String CHAR_PREFIX = "char: ";
    private static final String STRING_PREFIX = "string: ";

    private static final String OBJECT_PREFIX = "reference: ";

    public static String decorateNumber (int message) {
        return PRIMITIVE_PREFIX + message;
    }
    public static String decorateChar (char message) {
        return CHAR_PREFIX + message;
    }

    public static String decorateString (String message) {
        return STRING_PREFIX + message;
    }

    public static String decorateBoolean (boolean message) {
        return PRIMITIVE_PREFIX + message;
    }

    public static String decorateObject (Object message) {
        return OBJECT_PREFIX + message;
    }
}

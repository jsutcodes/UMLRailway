package io.github.jsutcodes.util.UML;

public enum AccessModifier {
    PUBLIC('+'),
    PRIVATE('-'),
    PROTECTED('#'),
    PACKAGE('~');

//  Not sure if this is where they belong since can be public and static etc.
//    DERIVED('/'),
//    STATIC('_')

    private char symbol;

    public final static String strPublic = "public";
    public final static String strPrivate = "private";
    public final static String strProtected = "protected";

    public final static String strPackage = "package";

    AccessModifier(char symbol) {
        this.symbol = symbol;
    }

    public static AccessModifier fromString(String type) {
        switch (type) {
            case strPublic:
                return PUBLIC;
            case strPrivate:
                return PRIVATE;
            case strPackage:
                return PACKAGE;
            case strProtected:
                return PROTECTED;
            default:
                return PUBLIC;
        }

    }

    @Override
    public String toString() {
        switch (this) {
            case PUBLIC:
                return strPublic;
            case PRIVATE:
                return strPrivate;
            case PROTECTED:
                return strProtected;
            case PACKAGE:
                return strPackage;
            default:
                return toString();
        }
    }
}

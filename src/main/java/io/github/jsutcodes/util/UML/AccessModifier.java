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

    AccessModifier(char symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        switch (this) {
            case PUBLIC:
                return "public";
            case PRIVATE:
                return "private";
            case PROTECTED:
                return "protected";
            case PACKAGE:
                return "package";
            default:
                return toString();
        }
    }


}

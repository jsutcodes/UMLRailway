package io.github.jsutcodes.util.RegEx;

public final class RegexPattern {

    /**
     * Regex pattern for finding Class Declarations and relationships of Java Files
     */
    public static final String JavaClassDefRegex="(public|protected|private|static|final)+\\s*(class|interface|enum)+\\s*(\\w+)\\s+(extends|implements)*\\s*(\\w+\\s|(?:\\w+,\\s*\\w+)*)";
    //public static final String JavaClassDefRegex="(public|protected|private|static|final) +\\s*(class|interface|enum)+\\s*(\\w+)(extends|implements|\\s)+([^,]+)\\{";

    //Regex regex2 = new Regex("(public|private|protected|static|final|native|synchronized|abstract|transient)+\\s)+[\\$_\\w\\<\\>\\[\\]]*\\s+[\\$_\\w]+\\([^\\)]*\\)?\\s*\\{?[^\\}]*\\}?");

    public static final String JavaAttributeRegex="";
    /**
     * Regex pattern for finding Method Declarations of Java Files
     */
    public static final String JavaMethodRegex="(public|protected|private|static|\\s) +([\\w\\<\\>\\[\\]]+\\s+)(\\w+) *(\\([^\\)]*\\)) *(\\{?|[^;])";


    private RegexPattern() { }

}

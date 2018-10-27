package io.github.jsutcodes.UMLDiagram;

import io.github.jsutcodes.UMLDiagram.IUMLDiagram.FileEnding;

public class UMLDiagramFactory {

    public static IUMLDiagram getUMLDiagram(FileEnding suffix) {

        switch (suffix) {
            case JAVA:
                return new JavaUMLDiagram();
            default:
                //throw new Exception("Unknown File Extension: Couldn't create UMLDiagram for filetype: "+ suffix);
                return null;
//            case C:
//                break;
//            case CPP:
//                break;
//            case C_HEADER:
//                break;
//            case CPP_HEADER:
//                break;
        }
    }

}

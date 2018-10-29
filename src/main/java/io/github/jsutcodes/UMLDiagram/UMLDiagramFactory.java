package io.github.jsutcodes.UMLDiagram;

import io.github.jsutcodes.UMLDiagram.IUMLDiagram.FileEnding;
import org.apache.commons.io.FilenameUtils;

import java.io.File;

public class UMLDiagramFactory {

    public static IUMLDiagram getUMLDiagram(File file) {

        switch (getFileEnding(file)) {
            case JAVA:
                System.out.println("Creating a Java UML Diagram Reader");
                return new JavaUMLDiagram(file);
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

    private static FileEnding getFileEnding(File file) {
        System.out.println("Getting Enum type from file: "+ file.getName());
        String fileExtension = FilenameUtils.getExtension(file.getName());
        return FileEnding.getByValue(fileExtension);
    }
}

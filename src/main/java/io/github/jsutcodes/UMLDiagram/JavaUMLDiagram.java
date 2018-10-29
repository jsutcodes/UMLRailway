package io.github.jsutcodes.UMLDiagram;

import io.github.jsutcodes.util.UML.ClassDiagram;

import java.io.File;

public class JavaUMLDiagram implements IUMLDiagram {


    private File javaFile;


    public JavaUMLDiagram(File file) {
        javaFile = file;
    }
    @Override
    public FileEnding getFileEnding() {
        System.out.println("Returning file ending: "+ FileEnding.JAVA);
        return FileEnding.JAVA;
    }

    @Override
    public ClassDiagram getUMLClassDiagram() {
        //TODO: read file and parse into a classDiagram object



        return null;
    }

    @Override
    public void readFile() {

    }

    @Override
    public String toString() {
        return "JavaUMLDiagram{}";
    }
}

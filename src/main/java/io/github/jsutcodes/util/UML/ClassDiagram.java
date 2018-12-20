package io.github.jsutcodes.util.UML;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.List;

public class ClassDiagram {

    private String className;
    private List<Pair<String,String>> classAtributes;
    private List <ClassMethod> classOperations;

    public ClassDiagram() {
        this(null);
    }

    public ClassDiagram(String className){
        this.className = className;
        classAtributes = new LinkedList<>();
        classOperations = new LinkedList();
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public void addClassAttribute(String attrName, String attrType) {
        Pair<String,String> newAttribute = new Pair<>(attrName, attrType);
        classAtributes.add(newAttribute);
    }

    public boolean removeClassAttribute(String attrName, String attrType) {
        return false;
    }

    public  void addClassOperation(ClassMethod classMethod) {
        classOperations.add(classMethod);
    }

    @Override
    public String toString() {
        //String classDiagramStr = "{";
        String classDiagramStr = String.format("{ \"className\":\"%s\", \"classAttributes\": %s, \"classOperations\": %s}",className, classAtributes, classOperations);
        return classDiagramStr;
    }
}

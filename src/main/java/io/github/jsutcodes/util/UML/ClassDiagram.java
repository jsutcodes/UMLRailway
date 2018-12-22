package io.github.jsutcodes.util.UML;


import java.util.LinkedList;
import java.util.List;

public class ClassDiagram {

    private String className;
    private List <ClassRelationship> classRelationships;
    private List<ClassRelationship> classAttributes;
    private List <ClassMethod> classOperations;

    public ClassDiagram() {
        this(null);
    }

    public ClassDiagram(String className){
        this.className = className;
        classRelationships = new LinkedList<>();
        classAttributes = new LinkedList<>();
        classOperations = new LinkedList();
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public void addClassAttribute(String attrName, String attrType) {
        ClassRelationship newAttribute = new ClassRelationship(attrName, attrType);
        classAttributes.add(newAttribute);
    }

    public boolean removeClassAttribute(String attrName, String attrType) {
        return false;
    }

    public void addClassOperation(ClassMethod classMethod) {
        classOperations.add(classMethod);
    }

    public void addClassRelationship(String className, String relationshipType) {
        classRelationships.add(new ClassRelationship(className,relationshipType));
    }


    @Override
    public String toString() {
        //String classDiagramStr = "{";
        String classDiagramStr = String.format("{ \"className\":\"%s\", \"classRelationships\": %s, \"classAttributes\": %s, \"classOperations\": %s}",className, classRelationships,  classAttributes, classOperations);
        return classDiagramStr;
    }
}

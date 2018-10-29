package io.github.jsutcodes.util.UML;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.List;

public class ClassMethod {

    private String methodName;
    private String returnType;

    public AccessModifier getVisibility() {
        return visibility;
    }

    public void setVisibility(AccessModifier visibility) {
        this.visibility = visibility;
    }

    private AccessModifier visibility;
    private List<Pair<String,String>> methodParam;

    public ClassMethod(String methodName) {
        this(methodName,"void");
    }

    public ClassMethod(String methodName, boolean isConstructor) {
        this(methodName, isConstructor? "constructor" : "void");
    }

    public ClassMethod(String methodName, String returnType) {
        this.methodName = methodName;
        this.returnType = returnType;
        this.setVisibility(AccessModifier.PUBLIC); // default

        methodParam = new LinkedList<>();
    }


    public void addParam(String paramName, String type) {
        Pair parameterToAdd = new Pair(paramName, type);
        methodParam.add(parameterToAdd);
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public String getReturnType() {
        return returnType;
    }

    public void setReturnType(String returnType) {
        this.returnType = returnType;
    }

//    @Override
//    public String toString() {
//        return ;
//    }
}

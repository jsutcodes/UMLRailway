package io.github.jsutcodes.UMLDiagram;

import io.github.jsutcodes.util.UML.AccessModifier;
import io.github.jsutcodes.util.UML.ClassDiagram;
import io.github.jsutcodes.util.UML.ClassMethod;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static io.github.jsutcodes.util.RegEx.RegexPattern.JavaClassDefRegex;
import static io.github.jsutcodes.util.RegEx.RegexPattern.JavaMethodRegex;

public class JavaUMLDiagram implements IUMLDiagram {


    private File javaFile;
    private ClassDiagram uml;


    public JavaUMLDiagram(File file) {
        System.out.println("Java uml diagram reader made ");
        javaFile = file;
    }

    @Override
    public FileEnding getFileEnding() {
        System.out.println("Returning file ending: " + FileEnding.JAVA);
        return FileEnding.JAVA;
    }

    @Override
    public ClassDiagram getUMLClassDiagram() {
        //TODO: read file and parse into a classDiagram object
        if (uml == null)
            uml = this.readFile();

        return uml;
    }

    @Override
    public ClassDiagram readFile() {
        // regex example
        Pattern methodRx = Pattern.compile(JavaMethodRegex);
        Matcher matcher = methodRx.matcher("");

        Pattern classRx = Pattern.compile(JavaClassDefRegex);
        Matcher classNameMatcher = classRx.matcher("");


        ClassDiagram umlDiagram = null;
        Scanner fileScanner = null;
        try {
            fileScanner = new Scanner(javaFile);
        } catch (FileNotFoundException e) {
            System.err.println("Could not find file for reading in JavaUMLDiagram.");
            e.printStackTrace();
            return umlDiagram;
        }

        umlDiagram = new ClassDiagram();
       // String className = javaFile.getName().substring(0, javaFile.getName().indexOf('.'));
       // System.out.println("classname is "+className);


        while (fileScanner.hasNextLine()) {
            String fileLine = fileScanner.nextLine().trim();
            matcher.reset(fileLine);
            classNameMatcher.reset(fileLine);
            //Scanner wordScanner = new Scanner(fileLine);

            AccessModifier modifierType = null;
            String methodName = null;
            String returnType = null;
            String params = null;

            if(classNameMatcher.find()) { //TODO: this doesn't work yet, figure out how and why
                System.out.println("Number of parts"+ matcher.groupCount());
                System.out.print("Classname: ");
                for (int i = 1; i <= classNameMatcher.groupCount(); i++) {
                    System.out.print(" match: "+ classNameMatcher.group(i)+"\n");
                    if(i == 3) {umlDiagram.setClassName(classNameMatcher.group(i));}
                    else if (i == 5 && !classNameMatcher.group(5).isEmpty()) { umlDiagram.addClassRelationship(classNameMatcher.group(i), classNameMatcher.group(4)); }
                }
            }

            if(matcher.find()) { //TODO: don't need a while loop just an 'if'
                System.out.println("Number of parts"+ matcher.groupCount());
                System.out.print("Method: ");
                for (int i = 1; i <= matcher.groupCount(); i++) {
                    System.out.print(" match: "+ matcher.group(i)+"\n");
                    if(i == 4) {params = matcher.group(i);}
                    else if(i == 3) {methodName = matcher.group(i);}
                    else if(i==2) {returnType = matcher.group(i).trim();}
                    else if (i ==1) {modifierType = AccessModifier.fromString(matcher.group((i)));}

                }
                ClassMethod newMethod = new ClassMethod(methodName);
                newMethod.setVisibility(modifierType);
                newMethod.setReturnType(returnType);
                handleMethodParams(newMethod,params);
                umlDiagram.addClassOperation(newMethod);
                System.out.println();


            }
        }
        return umlDiagram;
    }

    private void handleMethodParams(ClassMethod method, String params) {

        String param[] = params.replace("(", "")
                .replace(")", "")
                .replace(",","")
                .split("\\s+");

        for (int i = 0; i < param.length;i+=2) {
            method.addParam(param[i], param[i+1]);
        }

    }
}


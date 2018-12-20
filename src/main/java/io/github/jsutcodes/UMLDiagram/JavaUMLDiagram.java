package io.github.jsutcodes.UMLDiagram;

import io.github.jsutcodes.util.UML.AccessModifier;
import io.github.jsutcodes.util.UML.ClassDiagram;
import io.github.jsutcodes.util.UML.ClassMethod;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JavaUMLDiagram implements IUMLDiagram {


    private File javaFile;
    private ClassDiagram uml;


    public JavaUMLDiagram(File file) {
        System.out.println("JAva uml diagram reader made ");
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
        Pattern methodRx = Pattern.compile("(public|protected|private|static|\\s) +([\\w\\<\\>\\[\\]]+\\s+)(\\w+) *(\\([^\\)]*\\)) *(\\{?|[^;])");
        Matcher matcher = methodRx.matcher("");
        //Regex regex2 = new Regex("(public|private|protected|static|final|native|synchronized|abstract|transient)+\\s)+[\\$_\\w\\<\\>\\[\\]]*\\s+[\\$_\\w]+\\([^\\)]*\\)?\\s*\\{?[^\\}]*\\}?");


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
        String className = javaFile.getName().substring(0, javaFile.getName().indexOf('.'));
        System.out.println("classname is "+className);
        umlDiagram.setClassName(className);

        while (fileScanner.hasNextLine()) {
            String fileLine = fileScanner.nextLine().trim();
            matcher.reset(fileLine);
            Scanner wordScanner = new Scanner(fileLine);

//            if (matcher.find()) {
//                System.out.println("Found Method: ");
//            }

            AccessModifier modifierType = null;
            String methodName = null;
            String returnType = null;
            String params = null;

            while (matcher.find()) { //TODO: dont need a while loop just an 'if'
                System.out.println("Number of parts"+ matcher.groupCount());
                System.out.print("Method: ");
                for (int i = 1; i <= matcher.groupCount(); i++) {
                    System.out.print(" match: "+ matcher.group(i)+"\n");
                    if(i == 4) {params = matcher.group(i);}
                    else if(i == 3) {methodName = matcher.group(i);}
                    else if(i==2) {returnType = matcher.group(i).trim();}
                    else if (i ==1) {modifierType = AccessModifier.fromString(matcher.group((i)));}

                    // matched text: matcher.group(i)
                    // match start: regexMatcher.start(i)
                    // match end: regexMatcher.end(i)
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


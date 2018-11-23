package io.github.jsutcodes.UMLDiagram;

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
        Pattern methodRx = Pattern.compile("(public|protected|private|static|\\s) +[\\w\\<\\>\\[\\]]+\\s+(\\w+) *\\([^\\)]*\\) *(\\{?|[^;])");
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

            String methodName = null;

            while (matcher.find()) {
                System.out.println("Number of parts"+ matcher.groupCount());
                System.out.print("Method: ");
                for (int i = 1; i <= matcher.groupCount(); i++) {
                    System.out.print(" "+ matcher.group(i));
                    if(i==2) methodName = matcher.group(i);

                    // matched text: matcher.group(i)
                    // match start: regexMatcher.start(i)
                    // match end: regexMatcher.end(i)
                }
                ClassMethod newMethod = new ClassMethod(methodName);
                umlDiagram.addClassOperation(newMethod);
                System.out.println();


            }
        }
        return umlDiagram;
    }
}
//
//        @Override
//        public ClassDiagram readFile () {
//            ClassDiagram umlDiagram = null;
//            boolean classFlag = false;
//            boolean insideClass = false;
//            boolean variableFlag = false;
//            boolean methodFlag = false;
//
//            Scanner fileScanner = null;
//            try {
//                fileScanner = new Scanner(javaFile);
//            } catch (FileNotFoundException e) {
//                System.err.println("Could not find file for reading in JavaUMLDiagram.");
//                e.printStackTrace();
//                return umlDiagram;
//            }
//
//            umlDiagram = new ClassDiagram();
//            while (fileScanner.hasNextLine()) {
//                String fileLine = fileScanner.nextLine().trim();
//                Scanner wordScanner = new Scanner(fileLine);
//                try {
//                    if (fileLine.substring(0, 1).equals("/")) {
//                        //System.out.println("Don't iterate over comment lines");
//                        continue;
//                    }
//                } catch (Exception e) {
//                    //System.out.println("Must of hit new line");
//                    continue;
//                }
//                System.out.println(fileLine);
//                while (wordScanner.hasNext()) {
//                    //System.out.println("Getting next word ");
//                    String word = wordScanner.next();
//                    System.out.println("assessing word: " + word);
//
//                    switch (word.toLowerCase()) {
//                        case "class":
//                            System.out.println("setting class flag. Found word: " + word);
//                            classFlag = true;
//                            break;
//                        case "{":
//                            if (insideClass) methodFlag = true;
//                            else insideClass = true;
//                            break;
//                        case "}":
//                            if (methodFlag) methodFlag = false;
//                            else insideClass = false;
//                            break;
//                        default:
//                            if (classFlag) {
//                                classFlag = false;
//                                umlDiagram.setClassName(word);
//                            }
//                            if (insideClass) {
//                                if (!methodFlag)
//                                    umlDiagram.addClassAttribute(fileLine, "test");
//                                else { //this is close but wrong here
//                                    ClassMethod method = new ClassMethod(fileLine);
//                                    umlDiagram.addClassOperation(method);
//                                }
//                            }
//                            break;
//                    }
//                }
//            }
//            return umlDiagram;
//        }

//        @Override
//        public String toString() {
//            return uml.toString();
//        }


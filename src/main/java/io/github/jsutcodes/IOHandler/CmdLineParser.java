package io.github.jsutcodes.IOHandler;

import io.github.jsutcodes.UMLDiagram.IUMLDiagram;
import io.github.jsutcodes.UMLDiagram.UMLDiagramFactory;
import io.github.jsutcodes.util.UML.ClassDiagram;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * cmdLineParser - parses input from the file
 *  if its a directory it
 */
public class CmdLineParser {

    private String[] input;
    private IUMLDiagram  generator;

    private static final Logger logger = LogManager.getLogger();

    public CmdLineParser(String[] args) {
        input = args;
    }

    public void parse() throws Exception {
        logger.info("testing the logger...");
        if (input == null) {throw new Exception("No input detected."); }

        for (String word : input) {
            switch (word) {

                case "-h": case "--help":
                    usage();
                    System.exit(0);
                break;
                case "--GUI":
                    //Eventually implement a gui element to build Using graphics tools
                    break;

                default: // unrecognized flag or a system path
                    File path = new File(word);

                    if(path.exists()) {
                        if(path.isDirectory()) {
                            List<ClassDiagram> diagram = new ArrayList<>();
                            for (File f : path.listFiles()) {
                                ClassDiagram newClass = getUMLDiagram(f);
                                diagram.add(newClass);
                                System.out.println(newClass);
                            }
                        } else if(path.isFile()) {
                            System.out.println(getUMLDiagram(path));
                        }
                    } else { // path does not exists or is not a file or directory.
                        throw new Exception(String.format("Unrecognizable argument:(%s). Expected a file or Directory.",word ));
                    }
                break;
            }
        }
    }

    private ClassDiagram getUMLDiagram(File path) {
        System.out.println("Generating UML Diagram for file: "+ path.getName());
        generator = UMLDiagramFactory.getUMLDiagram(path);
        ClassDiagram umlDiagram = generator.getUMLClassDiagram();
        return umlDiagram;
    }
//    Should include in usage message:
//    The name of the program
//    Every non-optional command-line argument your program takes
//    Every optional command-line argument your program takes
//    Any extra descriptive material that the user should know about
    public void usage (Exception e) {
            System.out.println(e.getMessage());
            usage();
    }

    public void usage () {
        System.out.println("Usage:");
        System.out.println("\t UMLRailway.jar [FILE | DIR]\n");
        System.out.println("Given a file will generate a UMLDiagram for that file");
        System.out.println("--GUI\tStarts the UI client.");
        System.out.println("-h\tDisplays this message");

    }
}

// Notes for now: https://en.wikipedia.org/wiki/Class_diagram
// UML provides mechanisms to represent class members, such as attributes and methods, and additional information about them.
//        +	Public
//        -	Private
//        #	Protected
//        /	Derived (can be combined with one of the others)
//        ~	Package

// A relationship is a general term covering the specific types of logical connections found on class and object diagrams. UML defines the following relationships:
// solid flat line with arrow -> Association
// solid flat line with triangle -|> Inheritance
// dotted line with triangle --|> Realization/Implememntation
// dotted line with arrow --> Dependency
// clear diamond with solid line <>- agregation
// solid diamond with slid lines <filled> - Composition

// Multiplicity:
//        0	No instances (rare)
//        0..1	No instances, or one instance
//        1	Exactly one instance
//        1..1	Exactly one instance
//        0..*	Zero or more instances
//        *	Zero or more instances
//        1..*	One or more instances
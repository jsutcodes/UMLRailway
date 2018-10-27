package io.github.jsutcodes.IOHandler;

import io.github.jsutcodes.UMLDiagram.IUMLDiagram;
import io.github.jsutcodes.UMLDiagram.UMLDiagramFactory;

import java.io.File;
/**
 * cmdLineParser - parses input from the file
 *  if its a directory it
 */
public class CmdLineParser {

    private String[] input;
    private IUMLDiagram  generator;

    public CmdLineParser(String[] args) {
        input = args;
    }

    private enum Command {
        HELP("-h", "--help", null);

        private final String shortFlag;
        private final String longFlag;
        private final String nonOptional;

        Command(String sflag, String lflag, String noOpArg){
            this.shortFlag = sflag;
            this.longFlag = lflag;
            this.nonOptional = noOpArg;
        }

    }

    public void parse() throws Exception {
        if (input == null) {throw new Exception("No input detected."); }

        for (String word : input) {
            switch (word) {

                case "-h": case "--help":
                    usage();
                    System.exit(0);
                break;

                default: // unrecognized flag or a system path
                    File path = new File(word);

                    if(path.exists()) {
                        if(path.isDirectory()) {
                            // recursive option
                            throw new Error("Recursive UML not functional currently.");
                        } else if(path.isFile()) {

                        }
                    } else { // path does not exists or is not a file or directory.
                        throw new Exception(String.format("Unrecognizable argument:(%s). Expected a file or Directory.",word ));
                    }
                break;
            }
        }
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
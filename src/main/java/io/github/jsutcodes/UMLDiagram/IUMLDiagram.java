package io.github.jsutcodes.UMLDiagram;

import io.github.jsutcodes.util.UML.ClassDiagram;

public interface IUMLDiagram {
    // declare constant fields
    // declare methods that abstract
    // by default.

    enum FileEnding {
        C("c"),
        CPP("cpp"),
        CPP_HEADER("hpp"),
        C_HEADER("h"),
        JAVA("java");

        private String fileEnding;
        FileEnding(String suffix) {
            this.fileEnding = suffix;
        }

        public static FileEnding getByValue(String suffix) {
            for( FileEnding s : values()) {
                if(s.getSuffix().equalsIgnoreCase(suffix))
                    return s;
            }

            return  null;
        }

        private String getSuffix() {
            return fileEnding;
        }

    }

    public FileEnding getFileEnding();

    /**
     *  Parses source code and returns a ClassDiagram with information about the Class
     * @return ClassDiagram or null
     */
    public ClassDiagram getUMLClassDiagram();


    /**
     * read in the file and populate
     * fields to generate UML
     */
    public ClassDiagram readFile();



}

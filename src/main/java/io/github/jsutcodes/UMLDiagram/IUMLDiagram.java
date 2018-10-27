package io.github.jsutcodes.UMLDiagram;

import java.io.File;

public interface IUMLDiagram {
    // declare constant fields
    // declare methods that abstract
    // by default.

    enum FileEnding {
        JAVA(".java"),
        C(".c"),
        CPP(".cpp"),
        C_HEADER(".h"),
        CPP_HEADER(".hpp");

        private String fileEnding;

        FileEnding(String suffix){
            this.fileEnding = suffix;
        }
    }

    public FileEnding getFileEnding();



}

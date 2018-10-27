package io.github.jsutcodes.UMLDiagram;

import java.io.File;
import org.apache.commons.io.FilenameUtils;

public class UMLDiagram implements IUMLDiagram {

    private IUMLDiagram generator;

    public UMLDiagram(File file) {
        generator = UMLDiagramFactory.getUMLDiagram(FilenameUtils.getExtension(file));
    }

    @Override
    public FileEnding getFileEnding() {
        return generator.getFileEnding();
    }
}

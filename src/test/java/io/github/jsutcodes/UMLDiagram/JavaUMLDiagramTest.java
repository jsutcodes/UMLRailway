package io.github.jsutcodes.UMLDiagram;

import io.github.jsutcodes.util.UML.ClassDiagram;
import junit.framework.TestCase;
import org.junit.Ignore;
import org.junit.Test;

import java.io.File;

public class JavaUMLDiagramTest extends TestCase {

    @Ignore
    @Test
    public void testGenerateSimpleClassJson() {

        File bikeFile;
        JavaUMLDiagram bikeJavaClass = null;

        try {
            bikeFile = getResourceFile("Bicycle.java");
            // bikeFile = new File("C:\\Users\\jorsu\\git\\UMLRailway\\src\\test\\resources\\Bicycle.java");
            bikeJavaClass = new JavaUMLDiagram(bikeFile);

        } catch (NullPointerException e) {
            System.err.println("Test did not run. Resource File Not found");
            e.printStackTrace();
        }

        //assertEquals("JavaUMLDiagram should only work for files ending in .java", IUMLDiagram.FileEnding.JAVA, bikeJavaClass.getFileEnding());
        ClassDiagram bikeUml  = bikeJavaClass.getUMLClassDiagram();
        assertEquals("Has ClassName of Bike", "Bicycle",bikeUml.getClassName());

        //assertEquals("Has SetCadence Method",,);

        System.out.println(bikeUml);

    }

    private File getResourceFile(String resourceName) throws NullPointerException{

        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(resourceName).getFile());

        return file;

    }
    // Expected Simple JSON from Bicycle.java class
//    {
//        "className": "Bicycle"
//        "classAttributes": [
//            "cadence": "int",
//            "gear" : "int",
//            "speed" : "int"
//        ],
//        "classOperations": [
//            {"methodName": "Bicycle", "returnType": "constructor", "methodVisibitiy": "public", "params": [{"paramName":"startCadence"},{"paramType":"int"},{"paramName":"startSpeed"},{"paramType":"int"},{"paramName":"startGear"},{"paramType":"int"}] },
//            {"methodName": "setCadence", "returnType": "void", "methodVisibitiy": "public", "params": [{"paramName":"newValue"},{"paramType":"int"}] },
//            {"methodName": "setGear", "returnType": "void", "methodVisibitiy": "public", "params": [{"paramName":"newValue"},{"paramType":"int"}] },
//            {"methodName": "applyBrake", "returnType": "void", "methodVisibitiy": "public", "params": [{"paramName":"decrement"},{"paramType":"int"}] },
//            {"methodName": "speedUp", "returnType": "void", "methodVisibitiy": "public", "params": [{"paramName":"imcrement"},{"paramType":"int"}] }
//        ]
//
//
//
//    }

}
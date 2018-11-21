package io.github.jsutcodes.UMLDiagram;

import io.github.jsutcodes.util.UML.ClassDiagram;
import junit.framework.TestCase;
import org.junit.Ignore;
import org.junit.Test;

import java.io.File;
import java.net.URL;

public class JavaUMLDiagramTest extends TestCase {

    @Ignore
    @Test
    public void testGenerateSimpleClassJson() {

        File bikeFile;
        JavaUMLDiagram bikeJavaClass = null;

        try {
            //File bikeFile = getResourceFile("Bicycle.java");
             bikeFile = new File("C:\\Users\\jorsu\\git\\UMLRailway\\src\\test\\resources\\Bicycle.java");
            bikeJavaClass = new JavaUMLDiagram(bikeFile);



        } catch (NullPointerException e) {
            fail("Test did not run. Resource File Not found");
        }

        assertEquals("JavaUMLDiagram should only work for files ending in .java", IUMLDiagram.FileEnding.JAVA, bikeJavaClass.getFileEnding());
        //ClassDiagram bikeUML = bikeJavaClass.readFile();
        ClassDiagram bikeUml  = bikeJavaClass.getUMLClassDiagram();
        System.out.println(bikeUml);

    }

    private static File getResourceFile(String resourceName) throws NullPointerException{
        URL url = JavaUMLDiagramTest.class.getResource("/src/main/test/resources/"+resourceName );
        System.out.println(url);
        return new File((((URL) url).getPath()));
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
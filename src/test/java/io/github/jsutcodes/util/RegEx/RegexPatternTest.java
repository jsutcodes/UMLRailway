package io.github.jsutcodes.util.RegEx;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static io.github.jsutcodes.util.RegEx.RegexPattern.JavaClassDefRegex;
import static io.github.jsutcodes.util.RegEx.RegexPattern.JavaMethodRegex;
import static org.junit.Assert.*;

/**
 * RegexPatternTest is for running through the possible method declarations and class definitions possible
 * in the Java lang
 */
public class RegexPatternTest {

    Pattern methodRx,classRx;
    Matcher matcher, classNameMatcher;

    @Before
    public void setUp() throws Exception {
        methodRx = Pattern.compile(JavaClassDefRegex);
        matcher = methodRx.matcher("");

        classRx = Pattern.compile(JavaMethodRegex);
        classNameMatcher = classRx.matcher("");
    }

    // Tests for class definitions
    @Test
    public void simpleClassDefinitionTest() {
        String test = "public class Bicycle {";
        matcher.reset(test);
        System.out.println((String.format("Test for: %s",test)));
        assertTrue("matcher found match", matcher.find());
        assertEquals("first arg is public","public",matcher.group(1));
        assertEquals("second arg is class","class",matcher.group(2));
        assertEquals( "third arg is Bicycle", "Bicycle", matcher.group(3));

    }

    @Test
    public void simpleClassDefinitionWithSuperClassTest() {
        String test = "public class MountainBike extends Bicycle {";
        matcher.reset(test);
        System.out.println((String.format("Test for: %s",test)));
        assertTrue("matcher found match", matcher.find());
        assertEquals("Matcher has 5 groups", 5,matcher.groupCount());
        assertEquals("1st arg is public","public",matcher.group(1));
        assertEquals("2nd arg is class","class",matcher.group(2));
        assertEquals("3rd arg is MountainBike", "MountainBike", matcher.group(3));
        assertEquals("4th arg is extends", "extends",matcher.group(4));
        assertEquals("5th arg is Bicycle", "Bicycle",matcher.group(5).trim());

    }
    @Test
    public void simpleClassDefinitionWithInterfaceTest() {
        String test = "public class MountainBike implements NonMotorizedVehicle {";
        matcher.reset(test);
        System.out.println((String.format("Test for: %s",test)));
        assertTrue("matcher found match", matcher.find());
        assertEquals("Matcher has 5 groups", 5,matcher.groupCount());
        assertEquals("1st arg is public","public",matcher.group(1));
        assertEquals("2nd arg is class","class",matcher.group(2));
        assertEquals("3rd arg is MountainBike", "MountainBike", matcher.group(3));
        assertEquals("4th arg is implements", "implements",matcher.group(4));
        assertEquals("5th arg is NonMotorizedVehicle", "NonMotorizedVehicle",matcher.group(5).trim());

    }
    @Test
    public void simpleClassDefinitionWithMultipleInterfaceTest() {
        String test = "public class MountainBike implements NonMotorizedVehicle, IVehicle, TestInterface {";
        matcher.reset(test);
        System.out.println((String.format("Test for: %s",test)));
        assertTrue("matcher found match", matcher.find());
        assertEquals("Matcher has 5 groups", 5,matcher.groupCount());
        assertEquals("1st arg is public","public",matcher.group(1));
        assertEquals("2nd arg is class","class",matcher.group(2));
        assertEquals("3rd arg is MountainBike", "MountainBike", matcher.group(3));
        assertEquals("4th arg is implements", "implements",matcher.group(4));
        assertEquals("5th arg is NonMotorizedVehicle", "NonMotorizedVehicle, IVehicle, TestInterface",matcher.group(5).trim());

    }
    @Test
    public void simpleClassDefinitionWithSuperClassAndInterfaceTest() {
        String test = "public class MountainBike extends Bicycle implements NonMotorizedVehicle {";
        matcher.reset(test);
        System.out.println((String.format("Test for: %s",test)));
        assertTrue("matcher found match", matcher.find());
        assertEquals("Matcher has 5 groups", 5,matcher.groupCount());
        assertEquals("first arg is public","public",matcher.group(1));
        assertEquals("second arg is class","class",matcher.group(2));
        assertEquals( "third arg is MountainBike", "MountainBike", matcher.group(3));
        assertEquals("4th arg is extends", "extends",matcher.group(4));
        assertEquals("5th arg is Bicycle", "Bicycle",matcher.group(5).trim());
        assertEquals("6th arg is implements","implements",matcher.group(6).trim());
        assertEquals("7th arg is implements","extends",matcher.group(7).trim());

    }
    //Tests for Method declarations:





    @After
    public void tearDown() throws Exception {
    }
}
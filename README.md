# UMLRailway

Unified Modeling Language (UML) is a high level abstraction that lets coders focus on the architecture of code. Modeling is an Essential Part of large software projects, and helpful to medium and even small projects as well. It can be nice to see the UML diagram to get a general idea of how the project is built/layout. However, that isn't always available. UMLRailway is a project dedicated to reading existing repositories and generating a quick UML diagram for classes and how they related to each other.a By running UMLRailway in the source of a project it will parse through the files and quickly display a UML diagram that can be used to quickly see the outline of the project.  


 For a more detailed explanation on UML diagrams as it pertains to this project, see the [Unified Modeling Language Writeup](https://github.com/jsutcodes/UMLDiagram/UML.md). 
 or go to the [UML home page](http://www.uml.org) to read more about it. 
 
## How To Use
 #### Usage 
 ```bash
 java UMLRailway.jar [FILE | DIR] 
 ```
 #### Example 1: File
  ```
 java UMLRailway.jar /path/to/file/Bike.java
 Output:
        .___________________________.
        |            Bike           |  
        |---------------------------|
        | + setCadence(int newValue)|
        | + setGear(int newValue)   |
        | + applyBrake(int newValue)|
        | + speedUp(int newValue)   |
        |___________________________|
 ```
 
  #### Example 2: Directory
  ```
 java UMLRailway.jar /path/to/BikeDir/
 Output:
        .___________________________.             .___________________________.
        |            Bike           |             |        MountainBike       |  
        |---------------------------|             |---------------------------|
        | + setCadence(int newValue)| <-Extends-- | + setHeight(int newValue) |
        | + setGear(int newValue)   |             |___________________________|
        | + applyBrake(int newValue)|
        | + speedUp(int newValue)   |
        |___________________________|
 ```

## Built With

* [Maven](https://maven.apache.org/) - Dependency Management

## Versioning
TBD...
We use [SemVer](http://semver.org/) for versioning. For the versions available, see the [tags on this repository](https://github.com/your/project/tags). 

## Authors

* **Jordan Sutton** -[jsutcodes](https://github.com/jsutcodes)


# Setup Instructions

## JDK version used

This project was developed and tested using OpenJDK 25.

```## Run a "Hello World" program (brief explanation)

1. Create a file named `HelloWorld.java` in any folder (for example in the project root or a temporary folder):

```java
public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
    }
}
```
2. Open `cmd.exe` and change directory to where `HelloWorld.java` is saved.
3. Compile the Java file:

```
javac HelloWorld.java
```
This will produce `HelloWorld.class` (bytecode).

4. Run the program:

```
java HelloWorld
```
output:

```
Hello, World!
```

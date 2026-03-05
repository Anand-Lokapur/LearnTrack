# LearnTrack

LearnTrack is a small command-line Java application for managing students, courses, and enrollments. It demonstrates basic repository/service layering, simple ID generation utilities, and console-based menus for CRUD-like operations.

## Project description

This repository contains a lightweight learning management prototype. Key components:

- Entities: `Student`, `Course`, `Enrollment` represent core domain objects.
- Repositories: in-memory repositories (backed by `ArrayList`) for storing entities during runtime.
- Services: simple services that orchestrate repository operations and basic business rules.
- Utilities: ID generators for students, courses, and enrollments.

The application is intended for learning and demonstration, not production use.

## How to compile and run (Windows, cmd.exe)

1. Ensure you have JDK  installed and `javac`/`java` are on your PATH. Verify with:

```cmd
java -version
javac -version
```

2. From the project root (`c:\Users\anand\Projects\Airtribe\LearnTrack`), compile all `.java` files into an output folder (`out`):

```cmd
mkdir out
javac -d out src\com\airtribe\learntrack\**\*.java
```

Notes:
- If your shell doesn't expand the glob, you can compile from the root by listing files or by using an IDE (IntelliJ/Eclipse) that handles classpaths.
- Alternatively, compile all java files with a simpler (but heavier) command:

```cmd
javac -d out src\com\airtribe\learntrack\*.java src\com\airtribe\learntrack\**\*.java
```

3. Run the main class:

```cmd
java -cp out com.airtribe.learntrack.Main
```

That should start the console menu.

## Notes

- The project uses in-memory storage (`ArrayList`) and simple console I/O. For persistence, swap repositories with implementations that write to files or a database.
- For ease of development, open the project in an IDE — it will handle compilation and execution automatically.

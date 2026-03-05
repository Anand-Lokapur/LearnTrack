# Design Notes

This file explains several design choices made in the codebase: use of `ArrayList`, `static` members, and inheritance.

## Why `ArrayList` instead of arrays

- Dynamic sizing: `ArrayList` grows automatically when you add elements. The repositories need to add and remove entities at runtime and `ArrayList` removes the need to manage capacity manually.
- Rich API: `ArrayList` provides convenient methods like `add()`, `remove()`, `contains()`, and `stream()` which simplify repository implementations and make code more readable.
- Simplicity for an in-memory repository: For a small prototype, `ArrayList` gives good performance and minimal boilerplate compared to arrays.

In short, `ArrayList` was chosen for convenience, flexibility, and clearer code when managing collections of entities.

## Where `static` members are used and why

The codebase uses `static` members primarily in `Main.java` and in ID generator utilities:

- `Main.java` uses several `static` fields (for example `currentStage`, `sc` (Scanner), `running`, and repository/service instances). These are static because `Main` is structured as a simple console application with static menu-rendering methods and a static `main` method. Using static fields in this context allows the menu-rendering helper methods (which are also static) to access shared application state without creating an application-wide instance.

- ID generator utility classes (e.g., `studentIdGenerator`, `courseIdGenerator`, `enrollmentIdGenerator`) use a `private static int counter` to hold the running counter. The `counter` is static so that all instances (or calls) share the same sequence across the application runtime and IDs remain unique without needing to pass a generator instance around.

Why this is reasonable here:

- For a small CLI prototype, the static approach is simple and keeps the code straightforward.

Caveats and possible improvements:

- In larger applications, prefer instance-based services and use dependency injection (or a singleton pattern) to make testing easier and reduce global mutable state. Persisting ID sequences would also be important for a real system.

## Where inheritance is used and what was gained from it

- Entities: the project defines `Person` and `Student` where `Student` extends `Person`. Inheritance is used to share common fields (like name, email) and behavior between types that are conceptually related. This reduces duplication and groups shared logic in one place.

- Repository and service patterns: the code defines a `Repository<T, ID>` interface and concrete implementations (e.g., `StudentRepository`, `CourseRepository`, `EnrollmentRepository`). This uses interface-based polymorphism rather than class inheritance, but the effect is similar: a common contract for data access so services can depend on abstractions rather than concrete classes.

Benefits gained:

- Code reuse: shared fields and methods are implemented once in a base class/interface and reused by subclasses/implementations.
- Clearer design: abstractions (interfaces) make it easier to swap implementations (for example, replace `ArrayList`-backed repositories with database-backed repositories later).

## Closing

The choices prioritize simplicity and clarity for a small learning project. If the project grows, consider moving to instance-based services, using dependency injection, and introducing persistence for ID counters and entity storage.

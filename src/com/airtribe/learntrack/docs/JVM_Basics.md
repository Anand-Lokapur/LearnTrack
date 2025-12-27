# JVM Basics

## What are JDK, JRE, and JVM?

- JDK (Java Development Kit): A developer toolkit that includes the Java compiler (`javac`), tools, and the JRE. Use the JDK when you write and build Java programs.
- JRE (Java Runtime Environment): The runtime that contains the Java class libraries and the JVM. It lets you run Java programs but does not include the compiler.
- JVM (Java Virtual Machine): The software layer that executes Java bytecode on a machine. The JVM provides platform-specific implementations that interpret or just-in-time (JIT) compile bytecode into native instructions and manage memory.

In short: the JDK is for developers (compile + run), the JRE is for running Java programs, and the JVM is the runtime engine that actually executes bytecode.

## What is bytecode?

Bytecode is the intermediate, platform-independent representation of your Java program produced by the Java compiler. When you compile `MyClass.java` with `javac`, you get `MyClass.class` files containing bytecode. The JVM reads bytecode and either interprets it or JIT-compiles it to native code at runtime.

Because bytecode is standardized, the same `.class` files can be executed on any platform that has a compatible JVM.

## What does "write once, run anywhere" mean?

"Write once, run anywhere" describes Java's portability. You write Java source code and compile it to bytecode. That bytecode is not tied to any specific operating system or CPU architecture. Any machine with a compatible JVM can run the same bytecode without recompiling. Practically, this means developers can distribute compiled Java programs that run across different platforms (Windows, macOS, Linux) as long as a proper JVM is present.

There is a small caveat: the JVM must be compatible with the bytecode version (for example, class file versions tied to specific Java releases) and any platform-specific dependencies (native libraries) must be managed, but for pure Java code the portability model holds.

## Project Description

This is a simple Gradle Kotlin project configured with **cifuzz** and includes
one Fuzz Test.

## Run

```bash
cifuzz run com.example.FuzzTestCase::myFuzzTest
```

The Fuzz Test should trigger a Remote Code Execution.

## Coverage

```bash
cifuzz coverage com.example.FuzzTestCase::myFuzzTest
```

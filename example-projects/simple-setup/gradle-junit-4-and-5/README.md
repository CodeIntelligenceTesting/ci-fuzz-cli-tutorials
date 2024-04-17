## Project Description

This is a simple Gradle Java project configured with **cifuzz** and includes
one Fuzz Test and one JUnit 4 as well as one JUnit 5 Unit Test, demonstrating 
the use of the `junit-vintage-engine`.

## Run

```bash
cifuzz run com.example.ExploreFuzzTest::myFuzzTest 
```
The Fuzz Test should trigger a Remote Code Execution.


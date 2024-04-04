# cifuzz Gradle example

This is a simple Gradle based project with both JUnit 4 and JUnit 5 unit tests 
and a fuzz test.
It should quickly produce a finding, but slow enough to
see the progress of the fuzzer.

You can start fuzzing with

```bash
cifuzz run com.example.ExploreFuzzTest::myFuzzTest 
```

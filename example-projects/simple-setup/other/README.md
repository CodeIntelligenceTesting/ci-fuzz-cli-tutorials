# cifuzz other build systems example

This is a simple C++ project which doesn't use CMake, to demonstrate how
**cifuzz** can be used with other build systems.

What makes this project usable with **cifuzz** is the `my_fuzz_test`
target in the [Makefile](Makefile) and the `build-command` setting in
the [cifuzz.yaml](cifuzz.yaml).

You can start fuzzing with

```bash
cifuzz run my_fuzz_test
```

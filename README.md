# CI Fuzz CLI Tutorials

This repository contains example projects and tutorials to help you learn how to create your own fuzz tests with CI Fuzz CLI. 

## Tutorials

You can find the tutorials for the [C/C++](tutorials/c_cpp) and [Java](tutorials/java) projects in our official documentation:

* [C++](https://docs.code-intelligence.com/get-started/find-your-first-bug/cpp) 
* [Java](https://docs.code-intelligence.com/get-started/find-your-first-bug/java)

## Example projects

### Simple Setups
Simple project setups include a minimal project to showcase the CI Fuzz setup with one fuzz test included.
- [CMake](example-projects/simple-setup/cmake)
- [Bazel](example-projects/simple-setup/bazel)
- [Other](example-projects/simple-setup/other)
- [Maven](example-projects/simple-setup/maven)
- [Gradle (Java)](example-projects/simple-setup/gradle)
- [Gradle (Kotlin)](example-projects/simple-setup/gradle-kotlin)

Also included are [Gradle](example-projects/simple-setup/gradle-junit-4-and-5) and [Maven](example-projects/simple-setup/maven-junit-4-and-5) projects with both JUnit4 and JUnit5 unit tests, to demonstrate the use of the `junit-vintage-engine` together with fuzz tests.

### Advanced Setups

Advanced project setups include multiple modules or submodules, dependent on the build system with one or more fuzz tests.
- [CMake](example-projects/advanced-setup/cmake)
- [Bazel](example-projects/advanced-setup/bazel)
- [Other](example-projects/advanced-setup/other)
- [Maven](example-projects/advanced-setup/maven)
- [Gradle](example-projects/advanced-setup/gradle)

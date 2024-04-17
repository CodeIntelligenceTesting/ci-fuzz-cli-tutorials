## Project Description

This is a Gradle project configured with **cifuzz** which includes:

- class with multiple Fuzz Tests
- class with mixed Unit and Fuzz Tests
- changed source directory for test source set
- multi-project layout

## Run

### Remote Code Execution

```
cifuzz run -C app com.example.TestCases::remoteCodeFuzzTest

cifuzz run -C testsuite com.example.RCEFuzzTestCase::fuzzTestTrigger
```

### Array Out Of Bounds Exception

```
cifuzz run -C testsuite com.example.OutOfBoundsTestCase::fuzzTest
```

### Timeout

```
cifuzz run -C testsuite com.example.RCEFuzzTestCase::fuzzTestDontTrigger
```

## Bundle

### App

```
cifuzz -C app bundle
```

The bundle should include **1** Fuzz Test:

- `com.example.TestCases::remoteCodeFuzzTest`

### Testsuite

```
cifuzz -C testsuite bundle
```

The bundle should include **3** Fuzz Tests:

- `com.example.OutOfBoundsTestCase::fuzzTest`
- `com.example.RCEFuzzTestCase::fuzzTestTrigger`
- `com.example.RCEFuzzTestCase::fuzzTestDontTrigger`

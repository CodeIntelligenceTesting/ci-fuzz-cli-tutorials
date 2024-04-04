## Project Description

This is an extended example gradle project which covers custom project setups:

- multiple fuzz tests in one class
- mixed unit and fuzz tests in one class
- changed source directory for test source set
- multi-project layout
- more than one fuzzable class (with different findings)

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

Should include **1** fuzz test

- `com.example.TestCases::remoteCodeFuzzTest`

### Testsuite

```
cifuzz -C testsuite bundle
```

Should include **3** fuzz tests

- `com.example.OutOfBoundsTestCase::fuzzTest`
- `com.example.RCEFuzzTestCase::fuzzTestTrigger`
- `com.example.RCEFuzzTestCase::fuzzTestDontTrigger`

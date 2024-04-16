## Project Description

This is an extended example maven project which covers custom project setups:

- multiple fuzz tests in one class
- mixed unit and fuzz tests in one class
- changed source directory for test source set
- multi-project layout
- more than one fuzzable class (with different findings)

Right now we do not support a multi module project setup with maven so this project has two `cifuzz.yaml`,
one in the module `tests` and one in `util`.

## Setup

To run the fuzz tests, the Maven `install` command needs to be run to be able to resolve all dependencies.

```
mvn -Dmaven.test.skip=true install
```

## Run

### Exception

```
cifuzz -C util run util.UtilTest::joinFuzzTest
```
```
cifuzz -C tests run UtilFuzzTest::fuzzTest
```

### Negative Array Size Exception

```
cifuzz -C tests run NegativeArraySizeFuzzTest::fuzzTest
```

## Bundle

### Tests

```
cifuzz -C tests bundle
```

Should include **2** fuzz tests

- `NegativeArraySizeFuzzTest::fuzzTest`
- `UtilFuzzTest::fuzzTest`

### Util

```
cifuzz -C util bundle
```

Should include **1** fuzz test

- `util.UtilTest::joinFuzzTest`

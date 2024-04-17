## Project Description

This is an Maven project configured with **cifuzz** which includes:

- class with multiple Fuzz Tests
- class with mixed Unit and Fuzz Tests
- changed source directory for test source set
- multi-project layout

## Setup

To run the fuzz tests, the Maven `install` command needs to be called to be able 
to resolve all dependencies.

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

The bundle should include **2** Fuzz Tests:

- `NegativeArraySizeFuzzTest::fuzzTest`
- `UtilFuzzTest::fuzzTest`

### Util

```
cifuzz -C util bundle
```

The bundle should include **1** Fuzz Test:

- `util.UtilTest::joinFuzzTest`

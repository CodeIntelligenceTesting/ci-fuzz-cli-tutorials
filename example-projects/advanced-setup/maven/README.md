## Project Description

This is an extended example maven project which covers custom project setups:

- multiple fuzz tests in one class
- mixed unit and fuzz tests in one class
- changed source directory for test source set
- multi-project layout
- more than one fuzzable class (with different findings)

Right now we do not support a multi module project setup with maven so this project has two `cifuzz.yaml`,
one in the module `tests` and one in `util`.

## Run

### Exception

```
cd util
cifuzz run util.UtilTest::joinFuzzTest

cd tests
cifuzz run UtilFuzzTest::fuzzTest
```

### Negative Array Size Exception

```
cd tests
cifuzz run NegativeArraySizeFuzzTest::fuzzTest
```

## Bundle

### Tests

```
cd tests
cifuzz bundle
```

Should include **2** fuzz tests

- `NegativeArraySizeFuzzTest::fuzzTest`
- `UtilFuzzTest::fuzzTest`

### Util

```
cd util
cifuzz bundle
```

Should include **1** fuzz test

- `util.UtilTest::joinFuzzTest`

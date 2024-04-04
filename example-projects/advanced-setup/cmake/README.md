## Project Description

This is an extended example CMake project which includes two fuzz tests
`test_me_fuzztest`and `explore_me_fuzztest` in a multiple package setup.

## Run

### Heap Buffer Overflow and Undefined Behaviour

```
cifuzz run explore_me_fuzztest
```

### Heap Use After Free

```
cifuzz run test_me_fuzztest
```

## Bundle

```
cifuzz bundle
```

Should include both fuzz tests with four targets in total to cover
fuzzing and coverage builds.

```
...
- target: explore_me_fuzztest
  path: ibfuzzer/address+undefined/explore_me_fuzztest/bin/main/tests/explore_me_fuzztest
...
- target: test_me_fuzztest
  path: libfuzzer/address+undefined/test_me_fuzztest/bin/test_me_fuzztest
...
- target: explore_me_fuzztest
  path: replayer/coverage/explore_me_fuzztest/bin/main/tests/explore_me_fuzztest
...
- target: test_me_fuzztest
  path: replayer/coverage/test_me_fuzztest/bin/test_me_fuzztest
...
```

## Coverage

### explore_me_fuzz_test

```
cifuzz coverage explore_me_fuzztest
```

```
                              File | Functions Hit/Found |  Lines Hit/Found | Branches Hit/Found
           main/src/explore_me.cpp |      1 / 1 (100.0%) | 15 / 15 (100.0%) |     8 / 8 (100.0%)
main/tests/explore_me_fuzztest.cpp |      2 / 2 (100.0%) |   8 / 8 (100.0%) |     0 / 0 (100.0%)
                                   |                     |                  |                   
                                   | Functions Hit/Found |  Lines Hit/Found | Branches Hit/Found
                             Total |               3 / 3 |          23 / 23 |              8 / 8

```

### test_me_fuzztest

```
cifuzz coverage test_me_fuzztest
```

```
                          File | Functions Hit/Found | Lines Hit/Found | Branches Hit/Found
fuzztests/test_me_fuzztest.cpp |      2 / 2 (100.0%) |  6 / 6 (100.0%) |     0 / 0 (100.0%)
               lib/test_me.cpp |      1 / 1 (100.0%) |  9 / 9 (100.0%) |     2 / 2 (100.0%)
                               |                     |                 |                   
                               | Functions Hit/Found | Lines Hit/Found | Branches Hit/Found
                         Total |               3 / 3 |         15 / 15 |              2 / 2

```

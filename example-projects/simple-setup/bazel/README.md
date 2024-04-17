## Project Description

This is a simple Bazel project configured with **cifuzz** and has
one Fuzz Test.

## Run

```bash
cifuzz run src:explore_me_fuzz_test
```

The Fuzz Test should trigger a Heap Buffer Overflow.

## Create regression test

After you have discovered a Finding, you may want to include this as
part of a regression test. To replay findings from the
`src/explore_me_fuzz_test_inputs` directory:

```bash
bazel test --config=cifuzz-replay //src:explore_me_fuzz_test --test_output=streamed
```

Note that this requires these lines in your `.bazelrc`:

```bash
# Replay cifuzz findings (C/C++ only)
build:cifuzz-replay --@rules_fuzzing//fuzzing:cc_engine_sanitizer=asan-ubsan
build:cifuzz-replay --compilation_mode=opt
build:cifuzz-replay --copt=-g
build:cifuzz-replay --copt=-U_FORTIFY_SOURCE
build:cifuzz-replay --test_env=UBSAN_OPTIONS=halt_on_error=1
```

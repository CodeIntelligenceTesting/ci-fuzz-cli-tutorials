# cifuzz bazel example

This is a simple bazel based project, already configured with
**cifuzz**. It should quickly produce a finding, but slow enough to
see the progress of the fuzzer.

You can start the fuzzing with

```bash
cifuzz run //src:explore_me_fuzz_test
```

## Create regression test

After you have discovered a finding, you may want to include this as
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

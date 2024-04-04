# cifuzz CMake example

This is a simple CMake based project, already configured with
**cifuzz**. It should quickly produce a finding, but slow enough to
see the progress of the fuzzer.

You can start the fuzzing with

```bash
cifuzz run my_fuzz_test
```

## Create regression test

After you have discovered a finding, you may want to include this as
part of a regression test. This can be done by building the fuzz test
(my_fuzz_test) as a replayer binary. It is recommended to use the
provided CMake user presets, which can be generated with `cifuzz integrate cmake`.

```bash
cmake --preset="cifuzz (Regression Test)"
cmake --build --preset="cifuzz (Regression Test)"
```

To execute the replayer binary, run `./.cifuzz-build/replayer/address+undefined/my_fuzz_test`.
When you run the replayer binary, it will use any findings located in
the my_fuzz_test_inputs directory as input.

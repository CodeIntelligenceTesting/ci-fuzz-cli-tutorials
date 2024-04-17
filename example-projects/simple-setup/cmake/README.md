## Project Description

This is a simple CMake project configured with **cifuzz** and hasone 
Fuzz Test.

## Run

```bash
cifuzz run my_fuzz_test
```

The Fuzz Test should trigger a Heap Buffer Overflow.

## Create regression test

After you have discovered a finding, you may want to include this as
part of a regression test. This can be done by building the Fuzz Test
(`my_fuzz_test`) as a replayer binary. It is recommended to use the
provided CMake user presets, which can be generated with `cifuzz integrate cmake`.

```bash
cmake --preset="cifuzz (Regression Test)"
cmake --build --preset="cifuzz (Regression Test)"
```

To execute the replayer binary, run `./.cifuzz-build/replayer/address+undefined/my_fuzz_test`.
When you run the replayer binary, it will use any findings located in
the `my_fuzz_test_inputs` directory as input.

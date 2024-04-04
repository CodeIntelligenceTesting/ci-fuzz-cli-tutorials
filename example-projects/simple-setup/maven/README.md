# cifuzz Maven example

This is a simple Maven based project, already configured with
**cifuzz**. It should quickly produce a finding, but slow enough to
see the progress of the fuzzer.

To start make sure you installed **cifuzz** according to the
main [README](../../../README.md) and added your CI repository credentials
to Maven in `~/.m2/settings.xml`.

You can start fuzzing with

```bash
cifuzz run com.example.FuzzTestCase::myFuzzTest
```

## Coverage

cifuzz can generate Java coverage reports using
[jacoco](https://www.jacoco.org). This example is configured to use both HTML
and XML (e.g. for IDE support) as output formats.

Run the coverage command after your cifuzz run:

```bash
cifuzz coverage com.example.FuzzTestCase::myFuzzTest
```

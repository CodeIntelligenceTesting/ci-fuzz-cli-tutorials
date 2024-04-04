# cifuzz nodejs typescript example

This is a simple nodejs/npm based typescript project, already configured with
**cifuzz**. It should quickly produce a finding, but slow enough to
see the progress of the fuzzer.

To start make sure you installed **cifuzz** according to the
main [README](../../../README.md) and added your CI repository credentials
to NPM, e.g. in ~/.npmrc.

```
//gitlab.code-intelligence.com/api/v4/projects/89/packages/npm/:_authToken="<YOUR_TOKEN>"
```

After you ran `npm install`, you can start fuzzing with

```bash
cifuzz run FuzzTestCase
```

## Coverage

cifuzz can generate HTML coverage reports by running:

```bash
cifuzz coverage FuzzTestCase
```

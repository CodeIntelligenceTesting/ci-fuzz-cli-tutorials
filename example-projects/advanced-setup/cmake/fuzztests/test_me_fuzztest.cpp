#include "../lib/test_me.h"
#include <cifuzz/cifuzz.h>
#include <fuzzer/FuzzedDataProvider.h>

FUZZ_TEST_SETUP() {}

FUZZ_TEST(const uint8_t *data, size_t size) {
    FuzzedDataProvider fuzzed_data(data, size);
    std::string c = fuzzed_data.ConsumeRandomLengthString();
    testMe(c);
}

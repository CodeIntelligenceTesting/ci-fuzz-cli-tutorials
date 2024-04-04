#include "../src/explore_me.h"
#include <cifuzz/cifuzz.h>
#include <fuzzer/FuzzedDataProvider.h>

FUZZ_TEST_SETUP() {}

FUZZ_TEST(const uint8_t *data, size_t size) {
  FuzzedDataProvider fuzzed_data(data, size);
  int a = fuzzed_data.ConsumeIntegral<int>();
  int b = fuzzed_data.ConsumeIntegral<int>();
  std::string c = fuzzed_data.ConsumeRandomLengthString();

  exploreMe(a, b, c);
}

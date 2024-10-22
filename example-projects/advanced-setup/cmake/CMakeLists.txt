cmake_minimum_required(VERSION 3.3)
project(cmake_example)

set(CMAKE_CXX_STANDARD 11)
set(CMAKE_CXX_STANDARD_REQUIRED ON)

enable_testing()

find_package(cifuzz NO_SYSTEM_ENVIRONMENT_PATH)
enable_fuzz_testing()

add_subdirectory(main)
add_subdirectory(lib)

add_fuzz_test(test_me_fuzztest fuzztests/test_me_fuzztest.cpp)
target_link_libraries(test_me_fuzztest PRIVATE testMe)




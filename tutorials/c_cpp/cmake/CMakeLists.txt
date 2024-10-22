cmake_minimum_required(VERSION 3.3)
project(cmake_example)

set(CMAKE_CXX_STANDARD 11)
set(CMAKE_CXX_STANDARD_REQUIRED ON)

enable_testing()

add_subdirectory(src)

add_executable(${PROJECT_NAME} main.cpp )
target_link_libraries(${PROJECT_NAME} PRIVATE exploreMe)

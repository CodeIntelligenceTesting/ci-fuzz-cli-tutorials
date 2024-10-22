# Deliberately mixing styles here with one subdirectory including a CMakeLists.txt
# with the definitions and the other being defined in the parent CMakeLists.txt
add_library(exploreMe explore_me.cpp)
add_executable(${PROJECT_NAME} main.cpp)
target_link_libraries(${PROJECT_NAME} PRIVATE exploreMe)
target_link_libraries(${PROJECT_NAME} PRIVATE testMe)

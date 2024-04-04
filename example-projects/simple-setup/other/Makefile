CXXFLAGS += -std=c++11

all: main

clean:
	rm -f *.o *.a *.so a.out my_fuzz_test

libexplore.so: src/explore_me.cpp src/explore_me.h
	${CXX} ${CXXFLAGS} -shared -fpic -o libexplore.so $<

explore_me.o: src/explore_me.cpp src/explore_me.h
	${CXX} ${CXXFLAGS} -fpic $< -c

explore_me.a: explore_me.o
	ar rv api.a api.o

main: explore_me.o
	${CXX} ${CXXFLAGS} explore_me.o main.cpp

my_fuzz_test: libexplore.so
	@echo "Building $@"
# The FUZZ_TEST_CFLAGS, FUZZ_TEST_CXXFLAGS, and FUZZ_TEST_LDFLAGS
# environment variables are set by cifuzz when it executes the build
# command. Those must be passed to the compiler and linker when
# compiling and/or linking the fuzz test itself (compiling and
# linking is done in a single invocation here, so we pass compile
# and linker flags to $CXX in this case).
	${CXX} ${CXXFLAGS} ${FUZZ_TEST_CXXFLAGS} ${FUZZ_TEST_LDFLAGS} -o $@ $@.cpp -Wl,-rpath '-Wl,$$ORIGIN' -L. -lexplore

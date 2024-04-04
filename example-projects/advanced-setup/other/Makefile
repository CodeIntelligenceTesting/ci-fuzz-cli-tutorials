CXXFLAGS += -std=c++11

all: main

clean:
	rm -f *.o *.a *.so a.out my_fuzz_test

libexplore.so: main/src/explore_me.cpp main/src/explore_me.h
	${CXX} ${CXXFLAGS} -shared -fpic -o libexplore.so $<

explore_me.o: main/src/explore_me.cpp main/src/explore_me.h
	${CXX} ${CXXFLAGS} -fpic $< -c

explore_me.a: explore_me.o
	ar rv api.a api.o

libtest.so: lib/test_me.cpp lib/test_me.h
	${CXX} ${CXXFLAGS} -shared -fpic -o libtest.so $<

test_me.o: lib/test_me.cpp lib/test_me.h
	${CXX} ${CXXFLAGS} -fpic $< -c

test_me.a: test_me.o
	ar rv api.a api.o

main: explore_me.o test_me.o
	${CXX} ${CXXFLAGS} explore_me.o test_me.o main/src/main.cpp

main/tests/explore_me_fuzztest: libexplore.so
	@echo "Building $@"
# The FUZZ_TEST_CFLAGS, FUZZ_TEST_CXXFLAGS, and FUZZ_TEST_LDFLAGS
# environment variables are set by cifuzz when it executes the build
# command. Those must be passed to the compiler and linker when
# compiling and/or linking the fuzz test itself (compiling and
# linking is done in a single invocation here, so we pass compile
# and linker flags to $CXX in this case).
	${CXX} ${CXXFLAGS} ${FUZZ_TEST_CXXFLAGS} ${FUZZ_TEST_LDFLAGS} -o $@ $@.cpp -Wl,-rpath '-Wl,$$ORIGIN' -L. -lexplore

fuzztests/test_me_fuzztest: libtest.so
	@echo "Building $@"
# The FUZZ_TEST_CFLAGS, FUZZ_TEST_CXXFLAGS, and FUZZ_TEST_LDFLAGS
# environment variables are set by cifuzz when it executes the build
# command. Those must be passed to the compiler and linker when
# compiling and/or linking the fuzz test itself (compiling and
# linking is done in a single invocation here, so we pass compile
# and linker flags to $CXX in this case).
	${CXX} ${CXXFLAGS} ${FUZZ_TEST_CXXFLAGS} ${FUZZ_TEST_LDFLAGS} -o $@ $@.cpp -Wl,-rpath '-Wl,$$ORIGIN' -L. -ltest

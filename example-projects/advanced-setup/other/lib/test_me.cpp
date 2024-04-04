#include "test_me.h"
#include <string>
#include <cstdio>

using namespace std;

void testMe(const string& s) {
    if (s == "FUZZING") {
        char *c = (char *) malloc(1);
        free(c);
        ::printf("%s", c);
    } else {
        printf("%s", s.c_str());
    }
}

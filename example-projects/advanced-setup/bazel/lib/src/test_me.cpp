#include "lib/src/test_me.h"
#include <string>

using namespace std;

void testMe(string s) {
    if (s == "FUZZING") {
        char *c = (char *) malloc(1);
        free(c);
        ::printf("%s", c);
    } else {
        printf("%s", s.c_str());
    }
}

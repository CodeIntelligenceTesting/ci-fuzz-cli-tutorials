#include "explore_me.h"
#include <cstdio>
#include <cstring>
using namespace std;

void exploreMe(int a, int b, string c) {
  if (a >= 20000) {
    if (b >= 2000000) {
      if (b - a < 100000) {
        if (c == "FUZZING") {
          char *s = (char *)malloc(8);
          strcpy(s, "too long");
          printf("%s\n", s);
        }
      }
    }
  }
}

package com.example;

public class App {
    public static void main(String[] args) {
        ExploreMe.exploreMe(1, 1, "A");
        ExploreMe.exploreMe(2147483647, 1, "A");
        ExploreMe.exploreMe(2147483647, 2147483647, "A");
        ExploreMe.exploreMe(2000000000, 2000000123, "A");
        ExploreMe.exploreMe(2000000000, 2000000123, "FUZZING");
    }
}

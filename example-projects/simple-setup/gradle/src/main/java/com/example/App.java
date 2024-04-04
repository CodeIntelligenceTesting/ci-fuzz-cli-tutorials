package com.example;

public class App {
    public static void main(String[] args) {
        ExploreMe ex = new ExploreMe(1);
        ex.exploreMe(1, "A");
        ex.exploreMe(2147483647, "A");
        ex.exploreMe(2000000123, "A");
        ex.exploreMe(2000000123, "FUZZING");
    }
}

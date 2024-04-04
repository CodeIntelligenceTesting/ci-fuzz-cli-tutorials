package com.example;

public class ExploreMe {
    public static void exploreMe(int a, int b, String c) {
        if (a >= 20000) {
            if (b >= 2000000) {
                if (b - a < 100000) {
                    // Create reflective call
                    if (c.startsWith("@")) {
                        String className = c.substring(1);
                        try {
                            Class.forName(className).newInstance();
                        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ignored) {
                        }
                    }
                }
            }
        }
    }
}

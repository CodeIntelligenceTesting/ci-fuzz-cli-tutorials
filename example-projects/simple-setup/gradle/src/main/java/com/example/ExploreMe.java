package com.example;

public class ExploreMe {
    private final int a;

    public ExploreMe(int a) {
        this.a = a;
    }

    // Function with multiple paths that can be discovered by a fuzzer.
    public void exploreMe(int b, String c) {
        if (a >= 20000) {
            if (b >= 2000000) {
                if (b - a < 100000) {
                    // Trigger Remote Code Execution Bug
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

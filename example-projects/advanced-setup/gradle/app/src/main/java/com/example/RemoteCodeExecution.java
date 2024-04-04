package com.example;

import java.lang.reflect.InvocationTargetException;

public class RemoteCodeExecution {
    private int a = 0;

    public RemoteCodeExecution(int a) {
        this.a = a;
    }

    // Overloaded constructor that won't trigger RCE
    public RemoteCodeExecution() {
    }

    public void trigger(String b) {
        if (a != 0 && b.startsWith("@")) {
            // trigger Remote Code Execution vulnerability
            String className = b.substring(1);
            try {
                Class.forName(className).getDeclaredConstructor().newInstance();
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | NoSuchMethodException |
                     InvocationTargetException ignored) {
                // Don't do anything
            }
        }
    }
}

    

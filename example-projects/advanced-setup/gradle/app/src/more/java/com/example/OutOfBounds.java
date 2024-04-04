package com.example;

public class OutOfBounds {
    public void trigger(int i) {
        if (i > 1) {
            // Trigger Array Out of Bounds exception
            String[] arr = new String[i];
            System.out.println(arr[i]);
        }
    }
}

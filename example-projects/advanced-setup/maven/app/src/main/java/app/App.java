package app;

import util.Util;
import util.NegativeArraySize;

public class App {

    public static void main(String[] args) throws Exception {
        System.out.println(new App().greet("World!"));
        NegativeArraySize.negative(0);
    }

    public String greet(String name) throws Exception {
        return Util.join("Hello ", name);
    }
}

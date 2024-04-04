package util;

public class NegativeArraySize {
    
    public static void negative(int i) {
        if (i > 1) {
            String[] arr = new String[-i];
        }
        else {
            System.out.println("I am totally not a suspicious function!");
        }
    }
}

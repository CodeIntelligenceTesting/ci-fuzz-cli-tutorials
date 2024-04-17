import com.code_intelligence.jazzer.junit.FuzzTest;
import util.NegativeArraySize;

public class NegativeArraySizeFuzzTest {

    @FuzzTest
    void fuzzTest(int a) {
        // Trigger Negative Array Size Exception
        NegativeArraySize.negative(a);
    }
}

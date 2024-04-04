import com.code_intelligence.jazzer.api.FuzzedDataProvider;
import com.code_intelligence.jazzer.junit.FuzzTest;
import util.NegativeArraySize;

public class NegativeArraySizeFuzzTest {

    @FuzzTest
    void fuzzTest(FuzzedDataProvider data) {
        // Trigger Negative Array Size Exception
        NegativeArraySize.negative(data.consumeInt());
    }
}

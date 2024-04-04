import com.code_intelligence.jazzer.api.FuzzedDataProvider;
import com.code_intelligence.jazzer.junit.FuzzTest;
import util.Util;

public class UtilFuzzTest {

    @FuzzTest
    void fuzzTest(FuzzedDataProvider data) throws Exception {
        // Trigger Exception
        Util.join(data.consumeRemainingAsString());
    }
}

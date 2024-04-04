package util;

import com.code_intelligence.jazzer.api.FuzzedDataProvider;
import com.code_intelligence.jazzer.junit.FuzzTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UtilTest {

    @Test
    public void joinTest() throws Exception {
        // Example unit test
        assertEquals(Util.join("x", "y"), "xy");
    }

    @FuzzTest
    void joinFuzzTest(FuzzedDataProvider data) throws Exception {
        // Trigger Exception
        Util.join(data.consumeRemainingAsString());
    }
}

package util;

import com.code_intelligence.jazzer.junit.FuzzTest;
import com.code_intelligence.jazzer.mutation.annotation.NotNull;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UtilTest {

    @Test
    public void joinTest() throws Exception {
        // Example unit test
        assertEquals(Util.join("x", "y"), "xy");
    }

    @FuzzTest
    void joinFuzzTest(@NotNull String a) throws Exception {
        // Trigger Exception
        Util.join(a);
    }
}

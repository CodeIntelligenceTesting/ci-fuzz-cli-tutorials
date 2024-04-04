package util;

import org.apache.commons.lang3.StringUtils;

public class Util {

    public static String join(String... elements) throws Exception {
        if (elements[0].startsWith("@")) {
            throw new Exception("Gotcha!");
        }
        return StringUtils.join(elements);
    }
}

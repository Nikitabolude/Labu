package labs.lab6;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CustomEncodingHelperTest {

    @Test
    void testEncode() throws IOException {
        assertEquals("bcde", CustomEncodingHelper.encode("abcd", 1));
        assertEquals("cdef", CustomEncodingHelper.encode("abcd", 2));
        assertEquals("defg", CustomEncodingHelper.encode("abcd", 3));
    }

    @Test
    void testDecode() throws IOException {
        assertEquals("abcd", CustomEncodingHelper.decode("bcde", 1));
        assertEquals("abcd", CustomEncodingHelper.decode("cdef", 2));
        assertEquals("abcd", CustomEncodingHelper.decode("defg", 3));
    }

    @Test
    void testEncodeDecode() throws IOException {
        String s;
        int code = 4;

        s = "foo bar baz";
        assertEquals(s, CustomEncodingHelper.decode(CustomEncodingHelper.encode(s, code), code));

        s = "";
        assertEquals(s, CustomEncodingHelper.decode(CustomEncodingHelper.encode(s, code), code));

        s = "abc";
        assertEquals(s, CustomEncodingHelper.decode(CustomEncodingHelper.encode(s, code), code));
    }
}

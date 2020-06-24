package labs.lab6;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class CustomEncodingHelper {

    public static String encode(String str, int code) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        EncodingOutputStream encodingOutputStream = new EncodingOutputStream(byteArrayOutputStream, code);
        encodingOutputStream.write(str.getBytes());
        return byteArrayOutputStream.toString();
    }

    public static String decode(String str, int code) throws IOException {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(str.getBytes());
        DecodingInputStream decodingInputStream = new DecodingInputStream(byteArrayInputStream, code);
        return new String(decodingInputStream.readAllBytes());
    }
}

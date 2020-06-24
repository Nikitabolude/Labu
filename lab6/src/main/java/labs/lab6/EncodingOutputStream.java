package labs.lab6;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class EncodingOutputStream extends FilterOutputStream {

    private int code;

    public EncodingOutputStream(OutputStream out, int code) {
        super(out);
        this.code = code;
    }

    @Override
    public void write(int b) throws IOException {
        out.write(b + code);
    }
}

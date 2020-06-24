package labs.lab6;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class DecodingInputStream extends FilterInputStream {

    private int code;

    protected DecodingInputStream(InputStream in, int code) {
        super(in);
        this.code = code;
    }

    @Override
    public int read() throws IOException {
        int x = in.read();
        if (x == -1) {
            return -1;
        } else {
            return x - code;
        }
    }

    @Override
    public int read(byte[] b, int off, int len) throws IOException {
        int n = in.read(b, off, len);
        for (int i = 0; i < n; i++) {
            b[i + off] -= code;
        }
        return n;
    }
}

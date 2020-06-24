package labs.lab5;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Comparator;
import java.util.List;

public class SortedLineReader {

    public static List<String> readLinesSortedByLength(File file) throws IOException {
        List<String> ret = Files.readAllLines(file.toPath());
        ret.sort(Comparator.comparing(String::length));
        return ret;
    }
}

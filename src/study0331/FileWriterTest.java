package study0331;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterTest {

    public static void main(String[] args) throws IOException {
        FileWriter fw = new FileWriter("src/study0331/writer_file.txt");
        fw.write('A');

        char[] buf = {'B', 'C', 'D', 'E', 'F'};

        fw.write(buf);
        fw.write("안녕하세요.");

        fw.close();
    }
}

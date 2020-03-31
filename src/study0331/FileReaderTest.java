package study0331;

import java.io.*;

public class FileReaderTest {

    public static void main(String[] args) throws IOException {
        // 바이트로 읽는 경우 Reader로 변환하여 읽어야 함
        //FileInputStream fis = new FileInputStream("src/study0331/reader_file.txt");
        //InputStreamReader isr = new InputStreamReader(fis);

        // 문자로 읽는 경우
        FileReader fis = new FileReader("src/study0331/reader_file.txt");

        int i;
        while ((i = fis.read()) != -1) {
            System.out.print((char)i);
        }
    }

}

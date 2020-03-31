package study0331;

import java.io.*;
import java.net.Socket;

public class FileCopyTest {

    public static void main(String[] args) throws IOException {

        // 보조 스트림
        long milliseconds = 0;

        try (
                FileInputStream fis = new FileInputStream("src/study0331/dadong.zip");
                FileOutputStream fos = new FileOutputStream("src/study0331/copy.zip");
                BufferedInputStream bis = new BufferedInputStream(fis);
                BufferedOutputStream bos = new BufferedOutputStream(fos);
        ) {
            milliseconds = System.currentTimeMillis();

            int i;

            /*while ( (i = fis.read()) != -1){
                fos.write(i); // 1700ms
            }*/

            while ( (i = bis.read()) != -1){
                bos.write(i);   // 15ms
            }

            milliseconds = System.currentTimeMillis() - milliseconds;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("시간 : " + milliseconds);

        // decorator pattern
        Socket socket = new Socket();

        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        br.readLine();

    }
}

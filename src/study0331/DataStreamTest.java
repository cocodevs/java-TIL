package study0331;

import java.io.*;

public class DataStreamTest {
    public static void main(String[] args) {
        try (
            FileOutputStream fos = new FileOutputStream("src/study0331/data.txt");
            DataOutputStream dos = new DataOutputStream(fos);
            FileInputStream fis = new FileInputStream("src/study0331/data.txt");
            DataInputStream dis = new DataInputStream(fis);
        ){
            dos.writeByte(100);
            dos.write(50);
            dos.writeChar('A');
            dos.writeUTF("안녕하세요");

            // 읽을 때는 자료형에 맞게 읽어주어야함
            System.out.println(dis.readByte());
            System.out.println(dis.read());
            System.out.println(dis.readChar());
            System.out.println(dis.readUTF());

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

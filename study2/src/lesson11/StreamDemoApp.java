package lesson11;

import java.io.*;

public class StreamDemoApp {
    public static void main(String[] args) {
        try (DataOutputStream out = new DataOutputStream(new FileOutputStream("demo.txt"))) {
            out.writeInt(128);
            out.writeLong(128L);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (DataInputStream in = new DataInputStream(new FileInputStream("demo.txt"))) {
            System.out.println(in.readInt());
            System.out.println(in.readLong());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


package io;

import java.io.IOException;
import java.io.PipedWriter;
import java.io.PrintWriter;

/**
 * 缓冲字符流
 */
public class PWDemo {
    public static void main(String[] args) throws IOException {
        PrintWriter pw = new PrintWriter("./pw.txt","UTF-8");
        pw.println("该配合你演出的我视而不见");
        pw.print("啊八八八八");
        System.out.println("写出完毕");
        pw.close();
    }
}

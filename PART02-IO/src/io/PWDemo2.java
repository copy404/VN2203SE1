package io;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class PWDemo2 {
    public static void main(String[] args) throws FileNotFoundException {
        FileOutputStream fos = new FileOutputStream("pw2.txt", true);
        OutputStreamWriter osw = new OutputStreamWriter(fos, StandardCharsets.UTF_8);
        BufferedWriter bw = new BufferedWriter(osw);
        //当值设置为true时，表示打开了自动行刷新，每次调用println方法时，会自动调用flush一次
        PrintWriter pw = new PrintWriter(bw,true);
        Scanner scanner = new Scanner(System.in);
        while (true){
            String line = scanner.nextLine();
            if ("exit".equals(line)){
                break;
            }
            pw.println(line);
        }
        pw.close();
    }
}

package io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 实现文件复制
 */
public class CopyDemo {
    public static void main(String[] args) throws IOException {
        //创建一个输入流,读取原文件
        FileInputStream fis = new FileInputStream("./aaa.jpg");
        //创建一个输出流,将读取的原文件内容写出到目标文件中
        FileOutputStream fos = new FileOutputStream("./bbb.jpg");
        int d;//记录每次读取到的字节
        long start = System.currentTimeMillis();
        while ((d = fis.read())!=-1){//每次循环读取一个字节
            //每次循环也将读取到的字节写入到复制文件中
            fos.write(d);
        }
        long end = System.currentTimeMillis();
        System.out.println("复制完毕!共耗时:"+(end-start)+"ms");
        //关闭流资源
        fis.close();
        fos.close();
    }
}

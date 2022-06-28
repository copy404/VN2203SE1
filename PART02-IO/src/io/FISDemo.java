package io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * FIS FileInputStream 文件字节输入流
 */
public class FISDemo {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("./test.txt");
        //使用read方法每次读取文件中的一个字节
        //System.out.println((char)fis.read());
        //....
        //read方法读取不到内容时,会返回-1
        //System.out.println(fis.read());
        //System.out.println(fis.read());
        //while一般用于循环次数不确定  for一般用于利用循环次数
        int data;
        //循环条件是判断读取的字节是否是-1,并且把读取到的字节整数赋值给data,便于输出
        while ((data = fis.read())!=-1){//不等于-1说明能读到东西
            System.out.print((char)data);
        }
        //关闭流
        fis.close();
    }
}

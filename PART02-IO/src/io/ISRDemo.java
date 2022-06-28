package io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author 老安
 * @data 2022/6/16 21:43
 * 使用转换流测试读取文本数据
 */
public class ISRDemo {
    public static void main(String[] args) throws IOException {
        //将osw.txt中所有内容读取出来,并输出到控制台
        FileInputStream fis = new FileInputStream("./osw.txt");
        //创建一个字符转换流,连接fis低级输入流
        InputStreamReader isr = new InputStreamReader(fis);
        //读取一个字符,返回的int值内容本质上是一个char
        //但是如果返回的是-1,表示读取到了末尾
        //int d = isr.read();
        //System.out.println((char)d);
        int d;
        while ((d = isr.read())!=-1){
            System.out.print((char)d);
        }
        isr.close();
    }
}

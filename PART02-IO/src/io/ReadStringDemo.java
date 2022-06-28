package io;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @author 老安
 * @data 2022/6/14 20:57
 * 从note.txt中读取字符串
 */
public class ReadStringDemo {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("./note.txt");
        //准备一个数组,数组长度就是读取的文件大小
        //available 表示文件的长度
        byte[] data = new byte[fis.available()];
        //既然一次性读取完文件内容,所以只需要调用一次read方法
        fis.read(data);
        //read方法会将读取到的内容,存储到data数组中
        //data是一个字节数组,需要转换为字符串,并且指定编码
        //String的构造方法支持将给定的字节数组按照指定的编码还原为字符串
        String str = new String(data, StandardCharsets.UTF_8);
        System.out.println(str);
        fis.close();
    }
}

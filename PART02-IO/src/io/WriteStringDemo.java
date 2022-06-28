package io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @author 老安
 * @data 2022/6/14 19:44
 * 向文件中写出字符串
 */
public class WriteStringDemo {
    public static void main(String[] args) throws IOException {
        //向文件demo.txt写出文本数据
        FileOutputStream fos = new FileOutputStream("./demo.txt");
        String line = "smell smelly,taste tasty";//闻着臭吃着香
        //将字符串转换为字节数组,通常要指定转换的编码UTF-8
        //java.nio.charset.StandardCharsets;
        //StandardCharsets.UTF_8 表示UTF-8编码
        byte[] data = line.getBytes(StandardCharsets.UTF_8);
        fos.write(data);
        fos.write("闻着臭,吃着香".getBytes(StandardCharsets.UTF_8));
        fos.close();
    }
}

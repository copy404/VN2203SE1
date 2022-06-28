package io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

/**
 * @author 老安
 * @data 2022/6/16 21:22
 * java IO 将流按照读写的单位分为字节流和字符流
 * java.io.InputStream和OutputStream 是所有字节输入流和输出流的超类,
 * 读写的最小单位是字节
 * 而java.io.Reader和Writer 是所有字符输入流和输出流的超类,
 * 读写的最小单位是字符
 * 转换流:是一对常用字符流实现类:(写代码不常用,但是流链接很重要)
 * java.io.InputStreamReader InputStream输入流 Reader读
 * java.io.OutputStreamWriter OutputStream输出流 Writer写
 * 作用:
 * 1:在流链接中衔接其他的高级字符流和下面的字节流(这也是转换流名字的由来)
 * 2:负责将字符与对应的字节按照指定的字符集自动转换方便读写操作
 */
public class OSWDemo {
    public static void main(String[] args) throws IOException {
        //向osw.txt写入文本数据
        //创建一个低级的字节流
        FileOutputStream fos = new FileOutputStream("./osw.txt");
        //String line = "super idol的笑容都没你的甜~~~";
        //fos.write(line.getBytes(StandardCharsets.UTF_8));
        //创建一个字符流(转换流),连接低级的字节流fos
        //通常都需要指定字符集编码
        OutputStreamWriter osw = new OutputStreamWriter(fos,StandardCharsets.UTF_8);
        osw.write("super idol的笑容都没你的甜~~~");
        osw.write("八月正午的阳光都没你耀眼");
        osw.write("天天向上");
        osw.close();
    }
}

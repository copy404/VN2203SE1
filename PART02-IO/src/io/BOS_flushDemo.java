package io;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @author 老安
 * @data 2022/6/14 21:55
 * 缓冲流写出数据的缓冲区问题 面试题
 */
public class BOS_flushDemo {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream("./bos.txt");
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        bos.write("你是我的眼~~~~~~".getBytes(StandardCharsets.UTF_8));
        //如果不调用close方法,执行完毕,bos.txt没有内容
        //bos.flush();
        bos.close();
    }
}

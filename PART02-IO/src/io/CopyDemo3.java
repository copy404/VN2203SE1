package io;

import java.io.*;

/**
 * @author 老安
 * @data 2022/6/14 21:31
 * 使用缓冲流实现高效率文件复制
 */
public class CopyDemo3 {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("./aaa.jpg");
        BufferedInputStream bis = new BufferedInputStream(fis);
        FileOutputStream fos = new FileOutputStream("./ddd.jpg");
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        //此案例还是用单字节读取,之前读取很慢,现在用高级流测试
        int d;
        long start = System.currentTimeMillis();
        while ((d = bis.read())!=-1){//使用缓冲流读取字节
            bos.write(d);//使用缓冲流写入字节
        }
        long end = System.currentTimeMillis();
        System.out.println("耗时:"+(end-start)+"ms");
        //关闭流 如果使用了高级流,就只需要关闭高级流就可以了,会自动关闭所连接的低级流
        bis.close();
        bos.close();
    }
}

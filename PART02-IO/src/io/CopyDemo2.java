package io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 提高每次读取数据量减少实际读写的次数,可以提高效率
 * 一组字节一组字节的读写:块读写形式
 */
public class CopyDemo2 {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("./aaa.jpg");
        FileOutputStream fos = new FileOutputStream("./ccc.jpg");
        /*
         * 1.简单介绍实现思路
         * int read(byte[] data) 一次性读取给定的字节数组data总长度的字节量,
         * 返回的是实际读取到的字节量.如果返回的是-1时,表示读取到了末尾
         * 2.假定该文件就只有7个字节,然后四个字节一读取
         * aaa.jpg文件数据:
         * 10101010 10001101 10101000 00010010 10010110 10010101 01010101
         * byte[] data = new byte[4];
         * int len;该变量返回读取的字节数
         * 3.第一次调用方法读取4个字节
         * int len = read(data);
         * aaa.jpg文件数据:
         * 10101010 10001101 10101000 00010010 10010110 10010101 01010101
         * ^^^^^^^^ ^^^^^^^^ ^^^^^^^^ ^^^^^^^^
         * data:[10101010,10001101,10101000,00010010]
         * len:4 表示实际读取到了4个字节
         * 4:第二次调用方法读取4个字节,只剩三个字节
         * int len = read(data);
         * aaa.jpg文件数据:
         * 10101010 10001101 10101000 00010010 10010110 10010101 01010101
         *                                     ^^^^^^^^ ^^^^^^^^ ^^^^^^^^
         * data:[10010110,10010101,01010101,00010010]
         *      |----本次读到的新数据--------||-旧数据--|
         * len:3 表示实际读取到了3个字节
         * 5:第三次调用方法读取4个字节,但是已经没有内容可以读取了
         * data:[10010110,10010101,01010101,00010010]
         * len:-1 表示文件末尾了
         */
        /* byte[] data = new byte[10];
         * 1KB=1024byte
         * 1MB=1024KB
         * 1GB=1024MB
         * int t = 864000000;
         * int t = 60*60*24*1000
         */
        byte[] data = new byte[1024*10];//10kb
        int len;//记录每次读取到的字节
        long start = System.currentTimeMillis();
        while ((len = fis.read(data))!=-1){//每次循环读取一个字节
            //从下标0处开始写入,写入后面len个的字节
            fos.write(data,0,len);
        }
        long end = System.currentTimeMillis();
        System.out.println("复制完毕!共耗时:"+(end-start)+"ms");
        fis.close();
        fos.close();
    }
}

package io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * FOS FileOutputStream 文件输出流
 * 对File文件进行写出Output,使用的方式是Stream字节流
 */
public class FOSDemo {
    public static void main(String[] args) throws IOException {
        //1.创建FileOutputStream输出流,将数据输出到./test.txt文件中
        //File file = new File("./test.txt");
        //FileOutputStream fos = new FileOutputStream(file);
        //可以直接将文件的相对路径当做参数传递给流的构造方法
        //true如果不写,则默认是覆盖模式,每次写入内容,都会覆盖原有内容
        //如果写true,就是追加模式,不会覆盖原有内容
        FileOutputStream fos = new FileOutputStream("./test.txt",true);
        //2.开始向test.txt
        //向文件写出一个字节 参数单位是int
        //一个整数4个字节 传的是给定的int值的最后一个字节
        //00000000 00000000 00000000 00000001
        //bit 比特 8bit=1Byte
        fos.write(1);//00000001
        fos.write(97);
        fos.write(98);
        fos.write(99);
        fos.write(13);//回车
        fos.write(10);//换行
        //输出byte数组 \r\n 是回车换行
        fos.write("Hello EveryBody\r\n".getBytes());
        //输出byte数组的一部分,输出BCD,1表示ABCDE中的下标1处的元素(B),3表示输出后面的3个字节
        fos.write("ABCDE".getBytes(),1,3);
        System.out.println("输出完成");
        //3.关闭流(释放资源)
        fos.close();
    }
}

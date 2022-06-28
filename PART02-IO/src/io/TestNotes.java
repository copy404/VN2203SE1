package io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * @author 老安
 * @data 2022/6/14 20:26
 * 实现简易记事本工具
 * 程序启动后,要求将控制台输入的每一行字符串,写入到文件note.txt
 * 当在控制台输入exit时,程序退出
 */
public class TestNotes {
    public static void main(String[] args) throws IOException {
        System.out.println("请开始输入内容,单独输入exit退出记事本!");
        //接收控制台输入的内容的扫描器
        Scanner scanner = new Scanner(System.in);
        //使用文件输出流绑定note.txt文件
        FileOutputStream fos = new FileOutputStream("./note.txt",true);
        while (true){//因为不知道什么时候写完,所以定义一个死循环
            //接收在控制台输入的一行字符串
            String line = scanner.nextLine();
            //如果line是exit时,退出循环
            //由于line是用户输入的,现在不好控制,所以可能会输入一个空值,
            //空值调用方法,一定会发生空指针异常
            //equalsIgnoreCase String也提供了一个比较字符串向同时,忽略大小写差异
            if ("exit".equalsIgnoreCase(line)){
                break;//break跳出当前循环,直接执行循环之后的内容
            }
            fos.write(line.getBytes(StandardCharsets.UTF_8));
        }
        //执行完就关闭流
        fos.close();
    }
}

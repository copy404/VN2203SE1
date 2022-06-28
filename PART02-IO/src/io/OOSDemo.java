package io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * @author 老安
 * @data 2022/6/16 20:05
 * 对象流
 * java.io.ObjectOutputStream 对象输出流 序列化流
 * java.io.ObjectInputStream 对象输入流 反序列化流
 * 对象流是一对高级流,在流链接中完成对象与字节的转换,
 * 学会了使用这组流,就可以轻松读取任何的java对象
 */
public class OOSDemo {
    public static void main(String[] args) throws IOException {
        String name = "康荐文";
        int age = 18;
        String gender = "男";
        String[] otherInfo = {"单身的","帅气的","网络鉴黄师","多金"};
        Person p = new Person(name, age, gender, otherInfo);
        System.out.println(p);
        //将p对象序列化到person.obj文件中
        //创建一个文件输出流,绑定文件
        FileOutputStream fos = new FileOutputStream("./person.obj");
        //创建一个对象输出流,连接fos低级流
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        /*
        * writeObject(Object obj)
        * 对象输出流独有的方法:该方法会将对象转换为字节,并将字节通过
        * 所连接的流写出
        * */
        oos.writeObject(p);
        System.out.println("写出完毕!");
        //关闭流资源
        oos.close();
        /*
        * java.io.NotSerializableException 执行这个程序时,出现此异常,
        * 一定要检查序列化的类,是否实现了一个Serializable接口
        * */
    }
}

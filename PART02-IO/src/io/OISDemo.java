package io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * @author 老安
 * @data 2022/6/16 20:27
 * 使用对象输入流进行对象的反序列化
 */
public class OISDemo {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream("./person.obj");
        //创建一个对象输入流,连接fis低级流
        ObjectInputStream ois = new ObjectInputStream(fis);
        /*
        * Object readObject() 可以将文件中的字节读取出来,并且转换为java对象
        * 这个方法的返回值是Object,一般都需要强转为实际类型
        * */
        Person p = (Person) ois.readObject();
        System.out.println(p);
        ois.close();
    }
}

package file;

import java.io.File;
import java.io.IOException;

//使用File新建一个文件
public class CreateNewFileDemo {
    public static void main(String[] args) throws IOException {
//        File file = new File("./test.txt");
        //相对路径中"./"可以省略不写，默认就是从"./"开始的
        File file = new File("testday01.txt");
        //判断当前File对象表示的文件或者路径是否存在，如果存在，返回true，不存在返回false
        boolean exists = file.exists();//存在
        System.out.println("test.txt是否存在："+exists);
        if (exists){
            System.out.println("该文件已存在");
        }else{
            file.createNewFile();//create创造
        }
    }

}

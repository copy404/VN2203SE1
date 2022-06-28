package file;

import java.io.File;

//获取一个目录中的子项
public class ListFilesDemo {
    public static void main(String[] args) {
        File dir = new File(".");
        //boolean isDirectory() 判断当前File表示的是否为一个目录
        if (dir.isDirectory()){
            File[] subs = dir.listFiles();//列表文件
            System.out.println(dir.getName()+"有"+subs.length+"个子项");
            for (int i = 0; i < subs.length; i++) {
                System.out.println(subs[i].getName());
            }
        }
    }
}

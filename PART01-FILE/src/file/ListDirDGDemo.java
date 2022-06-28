package file;

import java.io.File;

public class ListDirDGDemo {
    public static void main(String[] args) {
        //指定要递归的目录
        File file = new File(".");
        //调用diGuiFolder方法，递归遍历上面指定的目录
        diGuiFolder(file);
    }
    //递归目录的方法，接收一个File对象
    public static void diGuiFolder(File file){
        if (file.isFile()){
            System.out.println("这是文件，不支持递归！");
            return;
        }else{
            File[] fs = file.listFiles();
            for (int i = 0; i < fs.length; i++) {
                if (fs[i].isFile()) {
                    System.out.println("文件："+fs[i]);
                }else{
                    System.out.println("目录："+fs[i]);
                    diGuiFolder(fs[i]);
                }
            }
        }
    }
}

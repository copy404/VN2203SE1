package file;

import java.io.File;

//创建一个目录
public class MkDirDemo {
    public static void main(String[] args) {
//        File file = new File("./demo");
        File file = new File("./a/b/c/d/e/f/g");
        if (file.exists()){
            System.out.println("该目录已存在");
        }else{
//            file.mkdir();//做，造 directory目录
            file.mkdirs();//创建多层级目录
            System.out.println("目录已创建");
        }
    }
}

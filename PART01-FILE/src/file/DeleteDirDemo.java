package file;

import java.io.File;

//删除目录
public class DeleteDirDemo {
    public static void main(String[] args) {
        File file = new File("./demo");
        if (file.exists()){
            file.delete();
            System.out.println("该目录已删除");
        }else{
            System.out.println("该目录不存在");
        }
    }
}

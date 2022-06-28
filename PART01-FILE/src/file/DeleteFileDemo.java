package file;

import java.io.File;

public class DeleteFileDemo {
    public static void main(String[] args) {
        File file = new File("./testday01.txt");
        if (file.exists()){
            file.delete();
            System.out.println("文件已删除");
        }else{
            System.out.println("文件不存在");
        }
    }
}

package file;

import java.io.File;
import java.io.FileFilter;

public class ListFileDemo2 {
    public static void main(String[] args) {
        File file = new File(".");
        FileFilter fileFilter = new FileFilter() {
            @Override
            public boolean accept(File file) {
                String name = file.getName();
                System.out.println("正在过滤元素：" + name);
                boolean c = name.contains("o");
                return c;
            }
        };
        File[] subs = file.listFiles(fileFilter);
        System.out.println("符合过滤规则的子项有："+subs.length);
        for (int i = 0; i < subs.length; i++) {
            System.out.println(subs[i].getName());
        }
    }
}

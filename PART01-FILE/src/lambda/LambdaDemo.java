package lambda;

import java.io.File;
import java.io.FileFilter;

public class LambdaDemo {
    public static void main(String[] args) {
        FileFilter fileFilter = new FileFilter() {
            @Override
            public boolean accept(File file) {
                return file.getName().contains("o");
            }
        };

        FileFilter fileFilter1 = (File file) -> {
            return file.getName().contains("o");
        };

        FileFilter fileFilter2 = (file) -> {
            return file.getName().contains("o");
        };

        FileFilter fileFilter3 = file -> {
            return file.getName().contains("o");
        };

        FileFilter fileFilter4 = file -> file.getName().contains("o");

    }
}

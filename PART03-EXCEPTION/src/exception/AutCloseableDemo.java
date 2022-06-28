package exception;

import java.io.IOException;
import java.io.FileOutputStream;

public class AutCloseableDemo {
    public static void main(String[] args) {
        try(
                FileOutputStream fos = new FileOutputStream("fos.txt");
                ) {
            fos.write(1);
        } catch (IOException e) {
            System.out.println("程序出错了");
        }
    }
}

package file;

import com.sun.jndi.ldap.sasl.LdapSasl;

import java.io.File;

public class FileDemo {
    public static void main(String[] args) {
        File file = new File("./demo.txt");
        String name = file.getName();
        System.out.println("文件的名字：" + name);
        long length = file.length();
        System.out.println("文件的长度：" + length + "字节");
        boolean cr = file.canRead();//是否可读
        boolean cw = file.canWrite();
        System.out.println("可读："+cr);
        System.out.println("可写："+cw);
        boolean ih = file.isHidden();
        System.out.println("是否隐藏："+ih);
    }
}

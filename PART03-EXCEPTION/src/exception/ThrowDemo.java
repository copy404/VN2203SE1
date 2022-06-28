package exception;

public class ThrowDemo {
    public static void main(String[] args) {
        Person p = new Person();
        try {
            p.setAge(200);
        } catch (IllegalAgeException e) {
            System.out.println("出错了");
        }
        System.out.println("此人的年龄："+p.getAge());
    }
}

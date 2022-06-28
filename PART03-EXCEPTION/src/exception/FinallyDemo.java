package exception;
//最终
public class FinallyDemo {
    public static void main(String[] args) {
        System.out.println("程序开始执行了");
        try {
            String str = null;
            System.out.println(str.length());
        } catch (Exception e) {
            System.out.println("出错了");
        }finally {
            System.out.println("finally中的代码执行了");
        }
        System.out.println("程序结束了");
    }
}

package thread;

public class ThreadDemo2{
    public static void main(String[] args) {
        MyRunnable1 r1 =new MyRunnable1();
        MyRunnable2 r2 = new MyRunnable2();
        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        t1.start();
        t2.start();
    }
}
class MyRunnable1 implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println("hello~大姐姐~");
        }
    }
}
class MyRunnable2 implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println("来了~老六~~");
        }
    }
}
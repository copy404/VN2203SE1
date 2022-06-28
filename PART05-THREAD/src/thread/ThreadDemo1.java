package thread;

public class ThreadDemo1 {
    public static void main(String[] args) {
        MyThread1 t1 = new MyThread1();
        MyThread2 t2 = new MyThread2();
        t1.start();
        t2.start();
    }
}
class MyThread1 extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println("你是谁啊？");
        }
    }
}
class MyThread2 extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println("开门，我是查水表的！");
        }
    }
}
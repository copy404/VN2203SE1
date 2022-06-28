package thread;

public class SyncDemo3 {
    public static void main(String[] args) {
        Thread t1 = new Thread(){
            @Override
            public void run() {
                Boo.doSome();
            }
        };
        Thread t2 = new Thread(() -> Boo.doSome());
        t1.start();
        t2.start();
    }
}
class Boo{
    public synchronized static void doSome(){
        Thread t = Thread.currentThread();
        System.out.println(t.getName()+"正在执行doSome方法。。。");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(t.getName()+"执行doSome方法完毕！");
    }
}
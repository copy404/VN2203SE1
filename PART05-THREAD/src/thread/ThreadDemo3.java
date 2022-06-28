package thread;

public class ThreadDemo3 {
    public static void main(String[] args) {
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    System.out.println("1");
                }
            }
        };
        Thread t1 = new Thread(r1);
        t1.start();
        Runnable r2 = () ->{
                for (int i = 0; i < 1000; i++) {
                    System.out.println("2");
                }
        };
        Thread t2 = new Thread(r2);
        t2.start();
    }
}
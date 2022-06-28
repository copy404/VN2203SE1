package thread;

/**
 * 线程的优先级
 */
public class PriorityDemo {
    public static void main(String[] args) {
        Thread min = new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    System.out.println("min");
                }
            }
        };
        Thread norm = new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    System.out.println("norm");
                }
            }
        };
        Thread max = new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    System.out.println("max");
                }
            }
        };
//        min.setPriority(1);
        min.setPriority(Thread.MIN_PRIORITY);
//        max.setPriority(10);
        max.setPriority(Thread.MAX_PRIORITY);

        norm.start();
        max.start();
        min.start();
    }
}

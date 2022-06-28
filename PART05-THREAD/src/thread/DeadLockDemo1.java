package thread;

public class DeadLockDemo1 {
    static Object chopsticks = new Object();
    static Object spoon = new Object();

    public static void main(String[] args) {
        Thread bf = new Thread() {
            @Override
            public void run() {
                try {
                    System.out.println("北方人准备吃饭。。。");
                    synchronized (chopsticks) {
                        System.out.println("北方人拿筷子，开始吃饭");
                        Thread.sleep(5000);
                        System.out.println("北方人吃完饭，准备喝汤");
                    }
                    System.out.println("北方人放下筷子，去拿勺");
                        synchronized (spoon) {
                            System.out.println("北方人拿勺，开始喝汤");
                            Thread.sleep(5000);
                            System.out.println("北方人喝汤了");
                        }
                        System.out.println("北方人放下勺");

                    System.out.println("北方人放下筷子，吃饭完毕！");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        Thread nf = new Thread() {
            @Override
            public void run() {
                try {
                    System.out.println("南方人准备吃饭。。。");
                    synchronized (spoon) {
                        System.out.println("南方人拿勺，开始喝汤");
                        Thread.sleep(5000);
                        System.out.println("南方人喝完汤，准备吃饭");
                    }
                    System.out.println("南方人放下勺，去拿筷子");
                        synchronized (chopsticks) {
                            System.out.println("南方人拿筷子，开始吃饭");
                            Thread.sleep(5000);
                            System.out.println("南方人吃饭了");
                        }
                        System.out.println("南方人放下筷子");

                    System.out.println("南方人放下勺，吃饭完毕！");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        bf.start();
        nf.start();
    }
}

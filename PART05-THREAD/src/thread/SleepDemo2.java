package thread;

public class SleepDemo2 {
    public static void main(String[] args) {
        Thread lin = new Thread() {
            @Override
            public void run() {
                System.out.println("林：刚没完容~睡一会吧~");
                try {
                    Thread.sleep(50000);
                    System.out.println("林：睡醒了！");
                } catch (InterruptedException e) {
                    System.out.println("林：干嘛呢，干嘛呢，都破相了!");
                }
            }
        };
        Thread huang = new Thread(() -> {
            System.out.println("黄：大锤80，小锤40，开始砸墙！");
            for (int i = 0; i < 5; i++) {
                System.out.println("黄：80！");

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("哐当！");
            System.out.println("黄：大哥，搞定！");
            lin.interrupt();
        });
        lin.start();
        huang.start();
    }
}

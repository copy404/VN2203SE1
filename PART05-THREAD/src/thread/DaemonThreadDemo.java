package thread;

public class DaemonThreadDemo {
    public static void main(String[] args) {
        Thread rose = new Thread(()->{
            for (int i = 0; i < 5; i++) {
                System.out.println("rose:let me go!");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("rose:aaaaaaa~~~");
            System.out.println("扑通！");
        });
        Thread jack = new Thread(() -> {
            while (true) {
                System.out.println("jack:you jump! i jump!");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        rose.start();
        jack.setDaemon(true);
        jack.start();
    }
}

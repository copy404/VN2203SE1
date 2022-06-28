package thread;

public class JoinDemo {
    static boolean isFinish = false;

    public static void main(String[] args) {
        Thread download = new Thread() {
            @Override
            public void run() {
                System.out.println("down:开始下载图片。。。");
                for (int i = 0; i <= 100; i++) {
                    System.out.println("down:" + i + "%");
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("图片下载完毕！！！");
                isFinish = true;
            }
        };
        Thread show = new Thread(){
            @Override
            public void run() {
                System.out.println("show:开始显示文字。。。");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("show:显示文字完毕！！！");
                try {
                    download.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("show：开始显示图片。。。");
                if (!isFinish){
                    throw new RuntimeException("图片加载失败！！！");
                }
                System.out.println("show:图片显示完毕！！！");
            }
        };
        download.start();
        show.start();
    }
}

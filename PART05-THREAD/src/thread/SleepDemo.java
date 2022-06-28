package thread;

public class SleepDemo {
    public static void main(String[] args) {
        System.out.println("程序开始了！");
        try {
            for (int i = 5; i > 0; i--) {
                    System.out.println("第"+i+"秒");
                Thread.sleep(1000);
                if (i == 1){
                    System.out.println("时间到！！！！");
                }
            }
        } catch (InterruptedException e) {//中断异常
            e.printStackTrace();
        }
        System.out.println("程序结束了！");
    }
}

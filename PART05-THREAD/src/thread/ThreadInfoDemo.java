package thread;

public class ThreadInfoDemo {
    public static void main(String[] args) {
        Thread main = Thread.currentThread();
        String name = main.getName();
        System.out.println("名字："+name);
        long id = main.getId();
        System.out.println("id："+id);
        int priority = main.getPriority();
        System.out.println("优先级："+priority);
        boolean alive = main.isAlive();
        System.out.println("线程是否活着："+alive);
        boolean daemon = main.isDaemon();
        System.out.println("是否为守护线程："+daemon);
        boolean interrupted = main.isInterrupted();
        System.out.println("是否被中断："+interrupted);
    }
}

package thread;

public class CurrentThreadDemo {
    public static void main(String[] args) {
        Thread main = Thread.currentThread();
        main.setName("niubi");
        main.setPriority(1);
        System.out.println(main);
        
    }
}


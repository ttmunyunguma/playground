package defaultt.multithreading;

public class ThreadExample1 {

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());
        Thread thread = new Thread(() -> {
            System.out.println("Running my thread");
            System.out.println(Thread.currentThread().getName());
            System.out.println("Run my thread");
        }
        );
        thread.start();
    }
}

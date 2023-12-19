package lambdasAndStreams;

import java.util.concurrent.Callable;

public class Main {
    public static void main(String[] args) {

        //Way 1
        Task task = new Task();
        Thread t1 = new Thread(task);
        t1.start();

        //Way 2
        Thread t2 = new Thread(new Runnable() { //Anonymous Inner class
            @Override
            public void run() {
                System.out.println("Hi from Anonymous Inner class");
            }
        });
        t2.start();

        //Lambda Expression
        // ()->{} //In JS arrow functions

        //Way 3 - Lambda Expression -> creating an object of the Runnable (Functional Interface) by giving the body of the `run` method
        Runnable r = () -> {
            System.out.println("Hi from Lambda Expression");
        };
        Thread t3 = new Thread(r);
        t3.start();

        //Way 4
        Thread t4 = new Thread(() -> {
            System.out.println("Hi from Lambda Expression2");
        });
        t4.start();

    }
}

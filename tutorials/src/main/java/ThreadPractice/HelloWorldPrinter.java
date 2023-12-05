package ThreadPractice;

public class HelloWorldPrinter implements Runnable{

    void doSomething(){
        System.out.println("Doing something from - " + Thread.currentThread().getName());
    }

    @Override
    public void run() {
        System.out.println("Hello World from - " + Thread.currentThread().getName());
        doSomething();
    }
}

package ThreadPractice;

public class Client {
    public static void main(String[] args) {

        HelloWorldPrinter helloWorldPrinter = new HelloWorldPrinter();

        //        Runnable helloWorldPrinter = new HelloWorldPrinter(); // Polymorphism makes this possible

//        helloWorldPrinter.run(); NOTE :: Runs the run() method in the same Main thread.

        //Explicitly instruct run() to create a new thread and execute in the newly created thread
        Thread t = new Thread(helloWorldPrinter); //Thread's contructor expects an argument of 'Runnable' type and HelloWorldPrinter implements Runnable.
        t.start();

        System.out.println("Current Thread - " + Thread.currentThread().getName());
    }
}

//----t1----t2--|--t3----
//----t4----t5--|--t6----

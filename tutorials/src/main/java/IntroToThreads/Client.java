package IntroToThreads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Client {

    public static void main(String[] args) {

        //Thread Pools in ExecutorService in Java Type 1
        ExecutorService es = Executors.newCachedThreadPool();

        //Thread Pools in ExecutorService in Java Type 2
//        ExecutorService es = Executors.newFixedThreadPool(10);

        for (int i=1;i<=100;i++){

            if(i == 80){
                System.out.println("DEBUG");
            }
            NumberPrinter np = new NumberPrinter(i);

            //Create new thread and execute

//            Thread t = new Thread(np);
//            t.start();

            //execute task in thread but using ExecutorService ie - ThreadPools
            es.execute(np);
        }
    }
}

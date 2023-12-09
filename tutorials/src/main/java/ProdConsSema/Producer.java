package ProdConsSema;

import java.util.concurrent.Semaphore;

public class Producer implements Runnable{
    private Store store;

    private Semaphore prodSema;
    private Semaphore consSema;
    Producer(Store st,Semaphore consSema,Semaphore prodSema) {
        this.store = st;
        this.prodSema = prodSema;
        this.consSema = consSema;
    }
    @Override
    public void run() {
        while(true){

            try {
                prodSema.acquire();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
//                    System.out.println("Cleared production check");
            store.addItem();
            consSema.release();

                }


        }

}

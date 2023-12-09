package ProdConsSema;

import java.util.concurrent.Semaphore;

public class Consumer implements Runnable{
    private Store store;

    private Semaphore consSema;

    private Semaphore prodSema;

    Consumer(Store st,Semaphore consSema,Semaphore prodSema){
        this.store = st;
        this.consSema = consSema;
        this.prodSema = prodSema;
    }
    @Override
    public void run() {
        while(true){

            try {
                consSema.acquire();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            store.removeItem();
            prodSema.release();
                }



    }
}
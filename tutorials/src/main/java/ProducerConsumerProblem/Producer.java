package ProducerConsumerProblem;

public class Producer implements Runnable{
    private Store store;
    Producer(Store st) {
        this.store = st;
    }
    @Override
    public void run() {
        while(true){
            synchronized (store){//Solves sync issues but allows only 1 thread to execute it's critical section at a time - efficiency can be improved by allowing more threads to execute their critical sections at a time
                if(store.getItems().size() < store.getMaxSize()) {
//                    System.out.println("Cleared production check");
                    store.addItem();
                }
            }


        }
    }
}

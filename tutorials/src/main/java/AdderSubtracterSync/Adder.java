package AdderSubtracterSync;

import java.util.concurrent.Callable;
import java.util.concurrent.locks.Lock;

public class Adder implements Callable<Void> {

    private Value value;

    Lock lock;

    Adder(Value v,Lock lock){
        value = v;
        this.lock = lock;
    }

    @Override
    public Void call() throws Exception {
        for(int i = 1;i<=50000;i++){
            //Method 1 - Lock and Unlock
            //            lock.lock();
//            this.value.value += i;
//            lock.unlock();

            //Method 2 - synchronized block
//            synchronized (value){
//                this.value.value += i;
//            }

            //Method 3 - synchronized methods
            value.incrementBy(i);
        }
        return null;
    }
}

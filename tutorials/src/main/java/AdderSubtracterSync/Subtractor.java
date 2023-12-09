package AdderSubtracterSync;

import java.util.concurrent.Callable;
import java.util.concurrent.locks.Lock;

public class Subtractor implements Callable<Void> {

    private Value value;

    private Lock lock;

    Subtractor(Value v,Lock lock){
        value = v;
        this.lock = lock;
    }
    @Override
    public Void call() throws Exception {
        for(int i = 1;i<=50000;i++){
//            lock.lock();
//            this.value.value -= i;
//            lock.unlock();
//            synchronized (value){
//                this.value.value -= i;
//            }
            value.decrementBy(i);
        }
        return null;
    }
}

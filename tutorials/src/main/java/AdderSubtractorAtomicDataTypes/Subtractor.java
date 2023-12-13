package AdderSubtractorAtomicDataTypes;

import java.util.concurrent.Callable;

public class Subtractor implements Callable<Void> {

    private Value value;

    Subtractor(Value v){
        value = v;
    }
    @Override
    public Void call() throws Exception {
        for(int i = 1;i<=50000;i++){
//            this.value.value -= i; // Non-atomic operation

            value.value.addAndGet(-i); // Atomic Operation. No Need for locks
        }
        return null;
    }
}

//int -> Integer
//void -> Void

//Autoboxing

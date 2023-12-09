package AdderSubtractor;

import java.util.concurrent.Callable;

public class Adder implements Callable<Void> {

    private Value value;

    Adder(Value v){
        value = v;
    }

    @Override
    public Void call() throws Exception {
        for(int i = 1;i<=50000;i++){
            this.value.value += i;
        }
        return null;
    }
}

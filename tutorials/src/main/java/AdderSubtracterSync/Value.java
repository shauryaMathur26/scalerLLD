package AdderSubtracterSync;

public class Value {

    public int value = 0;

    synchronized public void incrementBy(int i){
        this.value += i;
    }

    synchronized public void decrementBy(int i){
        this.value -= i;
    }

    //synchronized methods put a lock on the caller object

}

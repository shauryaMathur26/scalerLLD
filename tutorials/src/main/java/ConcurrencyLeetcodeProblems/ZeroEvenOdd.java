package ConcurrencyLeetcodeProblems;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

 //Problem Link - https://leetcode.com/problems/print-zero-even-odd/

public class ZeroEvenOdd {
    private int n;
    Semaphore zeroSema;
    Semaphore evenSema;
    Semaphore oddSema;

    public ZeroEvenOdd(int n) {
        this.n = n;
        this.zeroSema = new Semaphore(1);
        this.evenSema = new Semaphore(0);
        this.oddSema = new Semaphore(0);
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for(int i=0;i<n;i++){
            zeroSema.acquire();
            printNumber.accept(0);
            if(i%2==0){
                oddSema.release();
            }else{
                evenSema.release();
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for(int i=2;i<=n;i=i+2){
            evenSema.acquire();
            printNumber.accept(i);
            zeroSema.release();
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for(int i=1;i<=n;i=i+2){
            oddSema.acquire();
            printNumber.accept(i);
            zeroSema.release();
        }
    }
}

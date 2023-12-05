package IntroToThreads;

public class NumberPrinter implements Runnable{

    int number;

    //Parameterised Contructor
    NumberPrinter(int number){
        this.number = number;
    }


    @Override
    public void run() {
        System.out.println("Number - " + number + " Thread - " + Thread.currentThread().getName()); //We are able to call currentThread on the Thread class itself since that method is 'static'
    }
}

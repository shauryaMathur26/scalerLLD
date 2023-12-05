package Inheritance;

import java.util.Random;

public class Client {

    private static A randomiseObject(){ // Making the method static allows me to call it without creating an object
        Random random = new Random();
        int i = random.nextInt();

        return (i % 2 == 0)? new C():new B();
    }

    private static void doSomething2(A a){
        System.out.println(a);
    }

    public static void main(String[] args) {
        A a = randomiseObject();
        a.doSomething(); // Prints B's or C's overridden implementation depending on which type object gets created in the function (using random)
    }
}

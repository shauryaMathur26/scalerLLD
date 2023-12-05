package Polymorphism;

import java.util.Random;

public class Client {

    private static A doSomething(){
        Random random = new Random();

        int a = random.nextInt();

        if(a % 2 == 0){
            return new B();
        }else return new C();
    }
    public static void main(String[] args) {
        A a = doSomething(); //new B() or new C()

//        a.company = "Meta"; ERROR : Trying to access a property which will only be present if the real instance is created of type C. Compiler throws error and does not allow this since at the moment A type does not have this property.

        ((C)a).company = "Google"; //Explicit type casting - forcing the compiler - Can run into issues at runtime although compilation is successfully.
    }
}

package Interfaces;

public class A implements B{

    @Override
    public void doSomething() { // Forced to override method from implemented Interface B
        System.out.println("Hello");
    }
}

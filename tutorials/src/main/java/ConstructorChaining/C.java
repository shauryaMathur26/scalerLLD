package ConstructorChaining;

public class C extends B{
    C(){
        System.out.println("C constructor called");
    }
    C(String name){
        System.out.println("C constructor called " + name);
    }
}

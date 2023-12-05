package Polymorphism;

public class C extends A{
    String company;

    void ds(int a){ //primitive type data // ds(int)
        System.out.println(a);
    }
    void ds(Integer c){ // Object type // ds(Integer)
        System.out.println(c);
    }
}

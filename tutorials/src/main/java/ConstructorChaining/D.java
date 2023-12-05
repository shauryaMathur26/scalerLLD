package ConstructorChaining;

public class D extends C{
    D(){
        super("Hello"); //essentially same as C(param) - calling a parametrised constructor of immediate parent class
        //super() calls default constructor of immediate parent class.
        System.out.println("D constructor called");
    }

    //NOTE :: If any class in the chain does not have a public constructor, most-child class's object cannot e created since the contructor chain will break.
}

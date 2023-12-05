package Constructors;

public class Student {
    String name;
    int age = 15;

    //Default Contructor - creates a NEW object of class and initialises all attributes with default values (unless default value is provided)
    Student(){
        //Will create object with name : NULL and age : 15 (since age default value is given)
    }

    //Copy Constructor - Used if we want to create a NEW object with all exact same values as given already existing object
    Student(Student s){
        this.name = s.name;
        this.age = s.age;
    }

    //Parametrised Constructors
    private Student(String name){
        this.name = name;
    }
    private Student(String name,int age){
        this.name = name;
        this.age=age;
    }

    //NOTE :: If we create our custom contructor in a class - the default constructor will NO longer be provided by Java

    //NOTE :: If all constructors of a class are private ie - No public constructors are available, it is NOT possible to create an object of that class
}

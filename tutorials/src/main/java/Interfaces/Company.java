package Interfaces;


class Employee{
    String name;
    int salary;
    static String ceo; //static makes the field/method become accessible via the class itself. It is now common to all objects of the class and has a shared memory thereby saving space

    void printDetails(){
        System.out.println(name + " : " + salary + " : " + ceo);
    }

    static void printString(String s){
        System.out.println(s);
    }
}
public class Company {
    public static void main(String[] args) { // Main is a static method which allows being called as Company.main() without creating object of Company class.

        Employee e1 = new Employee();
        e1.name = "Shaurya";
        e1.salary = 2000;
        Employee.ceo = "Aman";

        Employee e2 = new Employee();
        e2.name = "Karan";
        e2.salary = 4000;
        e2.ceo = "Aman";

        e2.ceo = "Ashish";

        e1.printDetails();
        e2.printDetails();

        Employee.printString("hi");
    }
}

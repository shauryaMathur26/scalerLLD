package StaticKeyword;


class Constants{
    static final String ceoName = "Krishna";
}
class Employee{
    String name;
    int salary;
    static String ceo; //static makes the field/method become accessible via the class itself. It is now common to all objects of the class and has a shared memory thereby saving space

    void printDetails(){
        System.out.println(name +  " : " + salary +  " : " + ceo);
    }

    static void printCurrentTime(){
        System.out.println("Current Time - " + System.currentTimeMillis());
    }


}
public class Company {
    int x = 12;
    static int i = 0;
    public static void main(String[] args) { //Company.main() //Company c = new Company() // c.main() NOTE :: // Main is a static method which allows being called as Company.main() without creating object of Company class.


        System.out.println(Employee.ceo);
//        x =13; ERROR : Can only access static variables from a static method.Main is a static method.
        i=9;
        Employee e1 = new Employee();
        e1.name = "Shaurya";
        e1.salary = 1000;
        Employee.ceo = "Akash";

        Employee e2 = new Employee();
        e2.name = "Karan";
        e2.salary = 2000;
        Employee.ceo = "Akash";

        //1st way
//        Employee.ceo = "Manisha";

        //2nd way
        Employee.ceo = Constants.ceoName;
//        Constants.ceoName = "Anuj"; // Not possible because attribute is final
        //Another File
//        Employee.ceo = "Manisha";

        e1.printDetails();
        e2.printDetails();

        //static keyword in the method declaration allows me to call the method on the class itself ie - without creating any object of Employee class
        Employee.printCurrentTime();

    }
}

package Constructors;

public class Client {
    public static void main(String[] args) {
        Student student = new Student();
        System.out.println(student);
        doSomething(student);
        System.out.println("DEBUG");
    }

    private static void doSomething(Student student){ //Passed by Value - The value is the address to the obj
        student.age = 23;
        System.out.println(student);
        student = new Student(); //Won't change the address of student
        System.out.println(student);
    }
}

package ClassesAndObjects;

public class Student {

    String name;
    int age;
    String batchName;

    void changeBatchName(){
        System.out.println("Change batch");
    }

    void giveMockInterview(){
        System.out.println(name + " Giving mock interview ...");
    }
}

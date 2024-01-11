package PrototypeAndRegistry;

public class Client {

    public static  void fillRegistry(StudentRegistry studentRegistry){ // Emulating registry population at startup

        //Template 1
        Student aprBatchStudent = new Student();
        aprBatchStudent.setBatchName("Apr24");
        //Register Template 1 in Registry
        studentRegistry.register("Apr24",aprBatchStudent);

        //Template 2
        IntelligentStudent aprIntBatchStudent = new IntelligentStudent();
        aprIntBatchStudent.setBatchName("Apr24");
        aprIntBatchStudent.setIq(180);
        //Register Template 1 in Registry
        studentRegistry.register("aprIntelligentBatchStudent",aprIntBatchStudent);

    }
    public static void main(String[] args) {

        //Client should NOT have responsibility to create copy of the original object
        //        Student s = _____;
//        Student copy = new Student();
//        copy.age = s.age;
//        copy.iq

        //Make a copy
//        Student s = new Student();
//        Student copy = s.clone();

        //Fill Registry (emulating startup behaviour)
        StudentRegistry studentRegistry = new StudentRegistry();
        fillRegistry(studentRegistry);

        Student shaurya = studentRegistry.get("Apr24");
        shaurya.setName("Shaurya");
        Student sudharshan = studentRegistry.get("Apr24");
        sudharshan.setName("Sudarshan");
        Student intShaurya = studentRegistry.get("aprIntelligentBatchStudent");

        System.out.println("DEBUG");
    }
}

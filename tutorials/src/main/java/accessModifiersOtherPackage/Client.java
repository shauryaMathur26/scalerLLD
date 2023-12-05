package accessModifiersOtherPackage;

import accessModifiers.Student;

public class Client {
    public static void main(String[] args) {
        Student student = new Student();
//        student.name = "Karan"; ERROR : name is a private attribute
//        student.age = 22; ERROR : age is default, we are in a diff package
//        student.batchId = 456; ERROR : protected attr., and we are in a non-sub class in a diff package
        student.universityName = "IITD";

    }
}

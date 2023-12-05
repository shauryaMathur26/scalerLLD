package accessModifiersOtherPackage;

import accessModifiers.Student;

public class StudentChild extends Student {
    public static void main(String[] args) {
        StudentChild studentChild = new StudentChild();
//        studentChild.name = "Sam"; ERROR : private attribute
        studentChild.batchId = 789;
        studentChild.universityName = "IIMA";
//        studentChild.age = 56; ERROR : age has a default access modifier, and we are referring from subclass from outside package
    }
}

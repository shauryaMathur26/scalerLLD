package accessModifiers;

public class Client {
    public static void main(String[] args) {
        Student student = new Student();
//        student.name = "Sahil"; ERROR :name is a private attribute
        student.age = 26;
        student.batchId = 456;
        student.universityName = "IIT";

        System.out.println(student);
    }
}

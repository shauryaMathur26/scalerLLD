package PrototypeAndRegistry;

public class Student implements Prototype<Student>{

    private String name;
    int age;
    double psp;
    String batchName;

    Student(){}

    Student(Student other){
        System.out.println("Students Copy Constructor");
        this.name=other.name;
        this.age= other.age;
        this.batchName= other.batchName;
        this.psp= other.psp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getPsp() {
        return psp;
    }

    public void setPsp(double psp) {
        this.psp = psp;
    }

    public String getBatchName() {
        return batchName;
    }

    public void setBatchName(String batchName) {
        this.batchName = batchName;
    }

    @Override
    public Student clone() {

        return new Student(this);
    }
}

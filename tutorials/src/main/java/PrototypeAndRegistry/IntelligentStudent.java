package PrototypeAndRegistry;

public class IntelligentStudent extends Student{

    int iq;

    IntelligentStudent(){}

    IntelligentStudent(IntelligentStudent other){
        super(other);
        System.out.println("IntelligentStudents Copy Constructor");
        this.iq = other.iq;
    }

    public int getIq() {
        return iq;
    }

    public void setIq(int iq) {
        this.iq = iq;
    }

    @Override
    public IntelligentStudent clone() {
       return new IntelligentStudent(this);
    }
}

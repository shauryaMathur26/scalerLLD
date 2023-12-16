package collections;

public class Student implements Comparable<Student>{ // Comparable allows the natural ordering
    int id;
    String name;
    int age;
    double psp;

    Student(int id,String name, int age, double psp){
        this.id = id;
        this.name = name;
        this.age= age;
        this.psp = psp;
    }

    @Override
    public int compareTo(Student other) {
        //We are comparing "this" object with the other object
        //If this object has to be placed before the other -> -1
        //If this object has to be placed after the other -> 1
        //If equal -> 0
        if(this.id == other.id) return 0;
        else if(this.id < other.id) return -1;
        return 1;
    }
}

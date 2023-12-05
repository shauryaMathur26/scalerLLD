package ClassesAndObjects;



public class Main {
    public static void main(String[] args) {

//        int a = 5;
//        [DATATYPE] [VARIALE NAME] = [VALUE] -- Variable Declaration Syntax

        Student shaurya = new Student();
        shaurya.name = "Shaurya";
        shaurya.age = 26;
        shaurya.giveMockInterview();

        //Data Members of class (both attributes and methods) can be called from objects of class.

        Student check = shaurya;

        Student sahil = new Student();
        sahil.name = "Sahil";
        sahil.age = 21;
        sahil.giveMockInterview();
    }
}
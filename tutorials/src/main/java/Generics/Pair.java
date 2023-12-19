package Generics;

import java.util.List;

public class Pair <A,B>{ //A,B are the generics that will be used to create an object of this generic class

    A first;

    B second;

    public A getFirst() {
        return first;
    }

    public void setFirst(A first) {
        this.first = first;
    }

    public B getSecond() {
        return second;
    }

    public void setSecond(B second) {
        this.second = second;
    }

    public static <G,T,H> G addition(T num1,T num2, G g,H h){ //Mention whatever Generics you have to use in <>
        System.out.println("" + num1 + " " + num2 + " " + g );// String Concatenation

//        return num1 + num2;
        return g; //Return type is mention in signature right after <>
    }

    public static <T extends Number> double addition(T a, T b){ //Upper Bound
        return a.doubleValue() + b.doubleValue();
    }

    public static void dos1(List<? super Number> o){ //Lower Bound with Wildcard (?)
        System.out.println(o);
        //Since there is no use of the generic type in the method body,
        // we can use syntactical sugar to replace T with ?
    }

    public static void doS1(List<Object> o){

    }

    public static <T> void doS2(List<T> s){

    }

}

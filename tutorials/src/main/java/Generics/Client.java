package Generics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Client {
    public static void main(String[] args) {

        Pair<Integer,Integer> p1 = new Pair();
        p1.setFirst(1);
        p1.setSecond(2);

        Pair<Double,Double> coordinates = new Pair<>();
        coordinates.setFirst(123.0);

        List<Pair<Double,Double>> list = new ArrayList<>();
        List<Pair<String,Double>> list2 = new ArrayList<>();

        //Raw Types
        //Assuming <Object,Object>
        //Java does this to support Backward Compatibility
        Pair p3 = new Pair();
        p3.setFirst("String");
        p3.setSecond(456.3);

        HashMap map = new HashMap();
        map.put(1,"SDS");
        System.out.println(map.get(1));

        //Generic
        HashMap<String,Object> newMap = new HashMap<String, Object>();


//        Pair.addition("123",2.3,"Hello");

//        double sum = Pair.addition("String",2.3);
//        System.out.println(sum);

        List<Object> lo = new ArrayList<>();
        lo.add(1);
        lo.add(12.3);
        lo.add("String");

        List<Object> ls = new ArrayList<>();
        ls.add("1");
        ls.add(567);

        Pair.doS1(lo);
        Pair.doS2(ls);

        List<Object> list5 = new ArrayList<>();
        List<?> list6 = new ArrayList<>();

        list5.add(123);
        list6.add(null); //Only null can passed into List<?>

    }
}


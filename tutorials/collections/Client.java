package collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;
import java.util.Vector;

public class Client {
    public static void main(String[] args) {

//        List<Integer> list = Arrays.asList(5,1,2,7,6);

//        List<String> lStr = Arrays.asList("Amit","Lakhan","Bhai");

//        Collections.sort(lStr);

        List<String> lstr = new ArrayList<>();
        List<String> ll = new LinkedList<>();
        List<String> vector = new Vector<>();
        List<String> stack = new Stack<>();

        ll.add("A");
        ll.get(0);

        //HW Solve Producer-Consumer Problem using Vector

        Set<Integer> s1 = new HashSet<>();
        s1.add(10);
        s1.add(1);
        s1.add(-1);
        s1.add(4);

        for(Integer i : s1){
            System.out.println(i);
        }

        Set<Integer> s2 = new LinkedHashSet<>();
        s2.add(10);
        s2.add(1);
        s2.add(-1);
        s2.add(4);
        for(Integer i : s2){
            System.out.println(i);
        }

        Set<Integer> s3 = new TreeSet<>();
        s3.add(10);
        s3.add(1);
        s3.add(-1);
        s3.add(4);
        System.out.println("--------------");
        for(Integer i : s3){
            System.out.println(i);
        }
//    ENUM
        Payment p = new Payment();
//        p.status = "Random"; ERROR
        p.status = PaymentStatus.MERCHANT_ISSUE;

        Set<PaymentStatus> set = EnumSet.allOf(PaymentStatus.class);
        for(PaymentStatus ps : set){
            System.out.println(ps);
        }

        Queue<String> queue = new PriorityQueue<>();
        queue.add("Ketan");
        queue.add("Phaniraj");
        queue.add("Sumit");
        queue.add("Anuj");
        while (!queue.isEmpty()){
            System.out.println(queue.peek());
            queue.poll();
        }

        List<Student> students = new ArrayList<>(Arrays.asList(
                new Student(6,"Sumit",22,34.7),
                new Student(1,"Manisha",21,72.0),
                new Student(7,"Swar",26,52.8)
        ));

        // We need to know the natural order of sorting the objects of this class
        Collections.sort(students); // Without comparator : will use natural sorting ie Comparable
        Collections.sort(students,new StudentPSPComparator()); // Custom Comparator passed

        //Custom sorting order other than natural order -> Comparator

        //Collections is the utilities class for collections given to you by Java

        System.out.println("DEBUG");
    }
}

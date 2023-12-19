package lambdasAndStreams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsMain {
    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(11,24,12,4,5);

        //Creating an Integer stream on the list
        Stream<Integer> s = list.stream();

        //For Each :: Terminal Operation - loops over each collection element
        s.forEach(elem -> System.out.println(elem));

        Stream<Integer> s2 = list.stream();

        //s2.filter(elem -> {
        //  System.out.println(elem)
        // return elem%2 == 0
        // });

        //Filter -> Intermediate Operation :: Allows to filter only those stream objects which meet specifc criteria
                s2
                .filter(elem -> elem%2 == 0) // Can omit `(elem)` and write `elem` since only 1 argument is present
                .forEach(elem -> {
                    System.out.println(elem);
                    elem = elem +5;
                }); // Chaining of operations

        //toList - Terminal operation :: Collect the pipeline result into a new collection.
        Stream<Integer> s3 = list.stream();
        List<Integer> evenNumbers = s3
                .filter(elem -> elem%2 == 0) // Can omit the {} in lambda expression since 1 line method means return. Need {} for multiple lines of body
                        .collect(Collectors.toList());

        //Map :: Intermediate Operation - Performs a task/function/update for each stream object.
        Stream<Integer> s4 = list.stream();
        List<String> updatedNumbers = s4
//                .filter(elem -> elem%2 == 0)
                .map(elem -> "Hi " + elem + 5) //Modifying each Integer to String using Map operation
                .collect(Collectors.toList());

        //Sorted - Intermediate Operation :: Sorts the given stream on the basis of natural ordering unless given custom comparator
        Stream<Integer> s5 = list.stream();
        List<Integer> sortedNumbers = s5
                .filter(elem -> {
                    System.out.println("Filtering " + elem);
                    return elem%2 == 0;
                })
                                .sorted()
                .map(elem -> {
                    System.out.println("Mapping " + elem);
                    return elem + 5;
                })
                .collect(Collectors.toList());

        // findFirst - Terminal Operation - Returns the first object from the stream after the entire stream pipeline
        // There is a possibility that findFirst has nothing to return; can run into `null` issues since input stream can be empty to filter criteria filters out everything.
        // Thus, It returns an Optional<T> ie - a wrapper around your data to provide NULL safety
        Stream<Integer> s6 = list.stream();
        Optional<Integer> result = s6
                .sorted((o1,o2)->{
                    System.out.println("Sorting " + o1 + " " + o2);
                    return o1-o2;
                })
                .filter(elem -> {
                    System.out.println("Filtering " + elem);
                    return elem%2 == 0;
                })
//                .sorted()
                .map(elem -> {
                    System.out.println("Mapping " + elem);
                    return elem + 5;
                })
                .findFirst();

//        obj.id = result
//
        if(result.isPresent()){ // Returns true only if optional contains data
            System.out.println("Result - " + result.get()); //To get the value from the optional
        }

        System.out.println("OG List");
        for(Integer i : list){
            System.out.println(i);
        }

//        System.out.println("Even Numbers");
//        for(Integer i : evenNumbers){
//            System.out.println(i);
//        }
//
//        System.out.println("Updated Numbers");
//        for(String i : updatedNumbers){
//            System.out.println(i);
//        }
//
//        System.out.println("Sorted Numbers");
//        for(Integer i : sortedNumbers){
//            System.out.println(i);
//        }

        //HW :: Read and explore 'Reduce' operation for Java streams

//        List<Integer> l = Arrays.asList(1,2,3,4);
//
//        for(Integer i : l){
//
//            System.out.println(i);
//        }

    }
}

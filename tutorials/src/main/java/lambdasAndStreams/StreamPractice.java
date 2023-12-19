package lambdasAndStreams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamPractice {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        // Enter your code here
//        numbers.stream().forEach(num -> System.out.println(num*num));

        numbers.stream()
                .map(num -> num*num)
                .forEach(num -> System.out.println(num));

        List<String> names = Arrays.asList("Tantia Tope", "Rani Lakshmibai", "Mangal Pandey", "Nana Sahib");
        // Enter your code here
        List<Integer> nameLengths = names.stream()
                .map(name -> name.length())
                .collect(Collectors.toList());

        List<String> upperCaseNames = names.stream()
                        .filter(name -> !name.startsWith("T"))
                                .map(name -> name.toUpperCase())
                                        .collect(Collectors.toList());

        List<String> upperCaseNamesSorted = names.stream()
                .filter(name -> !name.startsWith("T"))
                .map(name -> name.toUpperCase())
                .sorted((s1,s2)-> s2.compareTo(s1))
                .collect(Collectors.toList());

        System.out.println("DEBUG");
    }
}

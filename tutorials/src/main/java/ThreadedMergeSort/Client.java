package ThreadedMergeSort;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Client {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        List<Integer> arr = Arrays.asList(8,1,9,2,6,3,7,5);
        ExecutorService es = Executors.newCachedThreadPool();
        Sorter arrSorter = new Sorter(arr,es);
        Future<List<Integer>> sortedArrayFuture = es.submit(arrSorter);
        List<Integer> sortedArray = sortedArrayFuture.get();

        System.out.println(sortedArray);
    }
}

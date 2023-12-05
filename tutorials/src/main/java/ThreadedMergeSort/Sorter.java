package ThreadedMergeSort;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class Sorter implements Callable<List<Integer>> {
    List<Integer> arr;

    ExecutorService es;

    //Constructor Overloading - having different constructors in same class with different method signatures ie - different params
    Sorter(List<Integer> arr){
        this.arr = arr;
    }
    Sorter(List<Integer> arr,ExecutorService es){ //passing es here to use the same thread pool as the one created in Client.
        this.arr = arr;
        this.es = es;
    }

    @Override
    public List<Integer> call() throws Exception {
        if(arr.size() <= 1) return  arr;

        int size = arr.size();
        int mid = size/2;

        List<Integer> leftArray = new ArrayList<>();
        List<Integer> rightArray = new ArrayList<>();

        for(int i=0;i<mid;i++){
            leftArray.add(arr.get(i));
        }
        for(int i=mid;i<size;i++){
            rightArray.add(arr.get(i));
        }

        Sorter leftArraySorter = new Sorter(leftArray,es);
        Sorter rightArraySorter = new Sorter(rightArray,es);

        //Pass these objects in the thread pool
//        ExecutorService es = Executors.newCachedThreadPool(); // Would have created a NEW ThreadPool in EACH recursion
        Future<List<Integer>> leftSortedArrayFuture = es.submit(leftArraySorter);
        Future<List<Integer>> rightSortedArrayFuture = es.submit(rightArraySorter);

        //Java actually waits till completion and get() returns the data after thread completed execution
        List<Integer> sortedLeftArray = leftSortedArrayFuture.get();
        List<Integer> sortedRightArray = rightSortedArrayFuture.get();

        // Merge Code

        int i= 0;
        int j = 0;

        List<Integer> sortedArray = new ArrayList<>();

        while (i < sortedLeftArray.size() && j < sortedRightArray.size()) {
            if (sortedLeftArray.get(i) <= sortedRightArray.get(j)) {
                sortedArray.add(sortedLeftArray.get(i));
                i += 1;
            } else {
                sortedArray.add(sortedRightArray.get(j));
                j += 1;
            }
        }

        while (i < sortedLeftArray.size()) {
            sortedArray.add(sortedLeftArray.get(i));
            i += 1;
        }

        while (j < sortedRightArray.size()) {
            sortedArray.add(sortedRightArray.get(j));
            j += 1;
        }

        return sortedArray;

    }
}

package exceptions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ExceptionsDemo {
    public static void main(String[] args) {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int i =1;
        int j = 10;

        try{
            int i = Integer.parseInt(br.readLine());
            int k = j/i;

            System.out.println(k);
        }catch(IOException e){
            System.out.println("IO Exception Occurred!");
        }
        catch(ArithmeticException e){
            System.out.println("Divide by 0 is NOT allowed");
        }catch(Exception e){
            System.out.println("Unexpected exception occurred!");
        }
        // We can have multiple catch blocks with a single try block.
        // Hierarchy of Exceptions
        // Hierarchy of catch blocks move from specific to more general
        // 'Exception' catches All exceptions hence, goes to the last in order of catch blocks
    }

    private static void recDemo(int i){
        while(i!=0){
            i++;
            recDemo(i);
        }
    }
}

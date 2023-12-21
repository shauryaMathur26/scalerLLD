package exceptions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ExceptionsDemo2 {
    public static void main(String[] args) throws MyException, IOException {


        int j = 10;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {

            br.close();
            int i = Integer.parseInt(br.readLine());

            System.out.println(i);
        }catch(IOException e){
            System.out.println("IOException Occurred!");
            throw new MyException("throwing my exception");
        }finally {
            //finally block executes ALWAYS. If something breaks in try block to moves to catch
            // If catch block itself propagates a new error, still finally block executes first before switching the flow of control.
            //Close resources - Example - DB,BR
            System.out.println("Close all resources in finally block");
        }

        // try with resources - Syntactical Sugar
        // The resource is automatically closed and memory is deallocated implicitly.
        // Compiler does NOT force to implement a `catch` Block or the `finally` block
        try(BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in))) {

            br2.close();
            int i = Integer.parseInt(br2.readLine());

            System.out.println(i);
        }
    }

        private static void doSomething() throws IOException{

        }

}

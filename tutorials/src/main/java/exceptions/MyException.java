package exceptions;

public class MyException extends Exception{ // Custom exceptions have to extend Exception class
    MyException(String message){
        super(message); // Calling constructor of parent `Exception` class
    }
}

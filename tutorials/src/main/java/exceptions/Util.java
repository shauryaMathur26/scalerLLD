package exceptions;

public class Util {

    public static void getStudentByRollNo(int i) throws ClassNotFoundException, MyException {
        if(i<30){
            if(i%2==0){
                //Throw my Custom Exception
                // String message is passed to my custom constructor which internally calls constructor of parent `Exception` class.
                throw new MyException("MyException Occurred!");
            }else{
                System.out.println(i);
            }
        }else{
            throw new ClassNotFoundException("Custom Message - Number greater than 30");
        }
    }
}

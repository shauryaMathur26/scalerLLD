package exceptions;

public class Demo3 {
    public static void main(String[] args) {

        try{
            Util.getStudentByRollNo(45);
        }catch(ClassNotFoundException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }catch(MyException e){
            System.out.println(e.getMessage());
        }
    }
}

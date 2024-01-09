package BuilderPattern;

public class Client {

    public static void main(String[] args) {

        // Rejected Method
        //        Student s = new Student("ABC",13,98.....);

        //New Approach
//        Builder builder = new Builder();
//        builder.setName("Shaurya");
//        builder.setGradYear(2013);
//        builder.setAge(32);
//
//        Student student = new Student(builder);
//
//        //Rewrite as Production Ready Builder
//        Builder builder1 = Student.getBuilder();
//        builder1.setName("Shaurya");
//        builder1.setGradYear(2013);
//        builder1.setAge(32);
//
//        Student newStudent = builder1.build();

        //After Chaining and build() Optimisation
        Student newStudent2 = Student.getBuilder()
                        .setName("Kripa")
                                .setGradYear(2019)
                                        .setAge(45).build();

        //Made constructor private, can't create Student Object via constructor
        //        Student newStudent3 = new Student(builder);

        System.out.println("DEBUG");
    }
}

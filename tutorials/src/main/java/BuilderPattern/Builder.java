package BuilderPattern;

//public class Builder {
//
//    String name;
//    int age;
//    double psp;
//    String universityName;
//    String batch;
//    long id;
//    int gradYear;
//    String phoneNumber;
//
//    public String getName() {
//        return name;
//    }
//
//    public Builder setName(String name) {
//        this.name = name;
//        return this;
//    }
//
//    public int getAge() {
//        return age;
//    }
//
//    public Builder setAge(int age) {
//        this.age = age;
//        return this;
//    }
//
//    public double getPsp() {
//        return psp;
//    }
//
//    public void setPsp(double psp) {
//        this.psp = psp;
//    }
//
//    public String getUniversityName() {
//        return universityName;
//    }
//
//    public void setUniversityName(String universityName) {
//        this.universityName = universityName;
//    }
//
//    public String getBatch() {
//        return batch;
//    }
//
//    public void setBatch(String batch) {
//        this.batch = batch;
//    }
//
//    public long getId() {
//        return id;
//    }
//
//    public void setId(long id) {
//        this.id = id;
//    }
//
//    public int getGradYear() {
//        return gradYear;
//    }
//
//    public Builder setGradYear(int gradYear) {
//        this.gradYear = gradYear;
//        return this;
//    }
//
//    public String getPhoneNumber() {
//        return phoneNumber;
//    }
//
//    public void setPhoneNumber(String phoneNumber) {
//        this.phoneNumber = phoneNumber;
//    }
//
//    public Student build(){
//        //Validations
//        if(this.getAge() < 30)
//            throw new IllegalArgumentException();
//       return new Student(this);
//    }
//}

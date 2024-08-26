package _07_Overview_of_OOP.Exercise03;

public class Student {
    private String fullName;
    private String address;
    private String email;
    private String phone;
    private String studentId;

    public Student(String fullName, String address, String email, String phone, String studentId) {
        this.fullName = fullName;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.studentId = studentId;
    }

    public void goToSchool(){
        System.out.println("Student " + getFullName() + " with id " + getStudentId() + " is going to school");
    }

    public void doHomeWork(){
        System.out.println("Student " + getFullName() + " with id " + getStudentId() + " is doing homework");
    }

    public void payTuition(){
        System.out.println("Student " + getFullName() + " with id " + getStudentId() + " is paying tuition");
    }

    public void doExam(){
        System.out.println("Student " + getFullName() + " with id " + getStudentId() + " is doing Exam");
    }

    @Override
    public String toString() {
        return "Student{" +
                "fullName='" + fullName + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", studentId='" + studentId + '\'' +
                '}';
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }


}

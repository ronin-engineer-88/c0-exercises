package _07_Overview_of_OOP.Exercise03;

public class Main {
    public static void main(String[] args) {
        Student student = new Student("Ronnin Enginner", "Ha noi", "Ronnin@gmail.com", "0123456789", "RN00001");
        student.goToSchool();
        student.doHomeWork();
        student.payTuition();
        student.doExam();
        System.out.println(student);
    }
}

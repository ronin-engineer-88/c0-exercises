package _10_Exception.homework.exercise_10;

public class Student {
    private String id;
    private String name;
    private String department;
    private double GPA;

    public Student() {
        this.id = "";
        this.name = "";
        this.department = "";
        this.GPA = 0.0;
    }

    public Student(String id, String name, String department, double GPA) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.GPA = GPA;
    }

    @Override
    public String toString() {
        return "ID: '" + id + '\'' +
                ", Tên: '" + name + '\'' +
                ", Khoa: '" + department + '\'' +
                ", GPA: " + GPA;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getGPA() {
        return GPA;
    }

    public void setGPA(double GPA) {
        this.GPA = GPA;
    }
}

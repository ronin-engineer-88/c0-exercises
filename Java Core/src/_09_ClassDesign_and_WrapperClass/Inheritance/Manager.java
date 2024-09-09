package _09_ClassDesign_and_WrapperClass.Inheritance;

public class Manager extends Worker{
    private String department;

    public Manager(String id, String name, int level, String department) {
        super(id, name, level);
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}

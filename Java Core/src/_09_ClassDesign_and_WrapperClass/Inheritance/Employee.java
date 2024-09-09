package _09_ClassDesign_and_WrapperClass.Inheritance;

public class Employee extends Worker{
    private String position;
    public Employee(String id, String name, int level, String position) {
        super(id, name, level);
        this.position = position;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}

package _09_ClassDesign_and_WrapperClass.DependencyRelation;

public class Paper {
    private String name;
    public Paper(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

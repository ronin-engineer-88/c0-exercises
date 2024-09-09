package _09_ClassDesign_and_WrapperClass.DependencyRelation;

public class Printer {
    public void print(Paper paper){
        System.out.println("Printing content of paper " + paper.getName());
    }
}

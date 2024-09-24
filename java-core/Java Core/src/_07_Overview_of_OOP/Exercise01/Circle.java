package _07_Overview_of_OOP.Exercise01;

public class Circle {
    private double radius;

    public Circle(double radius){
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double perimeter(){
        return 2*3.14*radius;
    }

    public double area(){
        return 3.14*radius*radius;
    }

    @Override
    public String toString(){
        return "Circle with radius " + radius +
                " have perimeter " + perimeter()
                + " and area " + area();
    }
}

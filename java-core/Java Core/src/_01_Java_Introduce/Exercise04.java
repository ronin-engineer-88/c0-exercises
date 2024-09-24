package _01_Java_Introduce;

public class Exercise04 {
    public static void main(String[] args) {

        double radius = 5.5;
        double pi = 3.141592653589793;

        // Công thức tính
        double perimeter = 2 * pi * radius; // chu vi
        double area = pi * radius * radius; // diện tích

        System.out.println("Chu vi hinh tron: " + perimeter);
        System.out.println("Dien tich hinh tron: " + area);
    }
}

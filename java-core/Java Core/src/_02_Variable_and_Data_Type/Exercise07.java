package _02_Variable_and_Data_Type;

import java.util.Scanner;

import static java.lang.Math.sqrt;

public class Exercise07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter three dimensions of the triangle: ");
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        double c = scanner.nextDouble();

        if(a < b + c && b < a + c && c < a + b) { // Kiểm tra điều kiện để thỏa mãn ba cạnh của một tam giác
            // Kiểm tra điều kiện để một tam giác là tam giác vuông
            if(a*a == b*b + c*c || b*b == a*a + c*c || c*c == a*a + b*b){
                if(a == b || b == c || c == a) // Kiểm tra tam giác vuông cân hay tam giác vuông thường
                    System.out.println("This is an isosceles right triangle");
                else
                    System.out.println("This is a normal right triangle");

            // Kiểm tra điều kiện để một tam giác là tam giác tù
            } else if (a*a > b*b + c*c || b*b > a*a + c*c || c*c > a*a + b*b){
                if(a == b || b == c || c == a) // Kiểm tra tam giác tù cân hay tam giác tù thường
                    System.out.println("This is an isosceles obtuse triangle");
                else
                    System.out.println("This is a normal obtuse triangle");

            // Kiểm tra điều kiện để một tam giác là tam giác đều
            } else if (a == b && b == c) {
                System.out.println("This is an equilateral triangle");

            // Kiểm tra đều kiện để một tam giác là tam giác nhọn
            } else {
                if(a == b || b == c || c == a) // Kiểm tra tam giác nhọn cân hay tam giác nhọn thường
                    System.out.println("This is an isosceles acute triangle");
                else
                    System.out.println("This is a normal acute triangle");
            }

            double perimeter = a + b + c; // Chu vi của tam giác
            double p = perimeter/2;
            double area = sqrt(p*(p-a)*(p-b)*(p-c)); // Diện tích tam giác theo công thức Heron
            System.out.println("The perimeter of the triangle: " + perimeter);
            System.out.println("The area of the triangle: " + area);

        } else {
            System.out.println("These are not valid three dimension of the triangle");
        }
    }
}

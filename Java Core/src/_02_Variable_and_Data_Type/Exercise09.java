package _02_Variable_and_Data_Type;

import java.util.Scanner;

import static java.lang.Math.abs;
import static java.lang.Math.sqrt;

public class Exercise09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the three coefficient of the quadratic equation");
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        double c = scanner.nextDouble();

        if (a == 0){ // Trường hợp hệ số a = 0
            if(b == 0){ // Trường hợp a = 0, b = 0
                if (c == 0) //Trường hợp a = 0, b != 0, c != 0
                    System.out.println("The equation has infinite solutions");
                else // Trường hợp a = 0, b != 0, c != 0
                    System.out.println("The equation has no solutions");
            } else { // Trường hợp a = 0, b != 0
                System.out.println("The equation has only one solution is " + -c/b);
            }

        } else { // Trường hợp hệ số a != 0
            double delta = b*b - 4*a*c;
            if(delta > 0){ // Nếu delta > 0 => Phương trình có hai nghiệm phân biệt
                double x1 = (-b + sqrt(delta))/(2*a);
                double x2 = (-b - sqrt(delta))/(2*a);
                System.out.println("The equation has two solutions: ");
                System.out.println("x1 = " + x1);
                System.out.println("x2 = " + x2);

            } else if (delta == 0) { // Nếu delta = 0 => Phương trình có nghiệm kép
                System.out.println("The equation has one solutions: " + -b/(2*a));

            } else { // Nếu delta < 0 => Phương trình có hai nghiệm phức (Nghiệm ảo) phân biệt
                double real = -b/(2*a);
                double imagine = sqrt(abs(delta))/(2*a);
                System.out.println("The equation has two imaginary solutions: ");
                System.out.println("x1 = " + real + "+ " + imagine + "i");
                System.out.println("x2 = " + real + "- " + imagine + "i");
            }
        }
    }
}

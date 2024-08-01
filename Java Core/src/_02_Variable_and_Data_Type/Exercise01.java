package _02_Variable_and_Data_Type;
import java.util.Scanner;

public class Exercise01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter value inch: ");
        double inches = scanner.nextDouble();

        double centimeters = inches * 2.54; // convert inch -> cm (1 inch = 2.54cm)
        System.out.println(inches + " inch = " + centimeters + " cm");
        scanner.close();
    }
}

/*
require: Viết chương trình đọc một đơn vị inch và chuyển sang đơn vị cm.
         Input là một số đơn vị inch, output là giá trị được chuyển sang đơn vị cm
        - Input: 1
        - Output: 2.54
*/

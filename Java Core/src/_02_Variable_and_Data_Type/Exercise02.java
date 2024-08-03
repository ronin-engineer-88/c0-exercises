/**
 * Viết chương trình chuyển đổi độ F sang độ C và ngược lại. Input nhận vào 2 giá trị, giá trị thứ nhất là loại nhiệt độ hiện tại là C hoặc F. giá trị thứ hai là số nhiệt độ cần chuyển như: 10, 20 hoặc 99. Output là giá trị nhiệt độ đã chuyển.
 * - Input 1: C 40
 * - Output 1: 104
 * - Input 2: F 10
 * - Output 2: -12.2
 */

package _02_Variable_and_Data_Type;

import java.util.Scanner;

public class Exercise02 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Nhập loại nhiệt độ hiện tại (C hoặc F): ");
        String type = scanner.next();

        System.out.println("Nhập giá trị nhiệt độ cần chuyển đổi");
        double temperature = scanner.nextDouble();

        // Chuyển đổi nhiệt độ và in ra kết quả
        if (type.equalsIgnoreCase("C")) {
            double convertedTemperature = celsiusToFahrenheit(temperature);
            System.out.println(convertedTemperature);
        } else if (type.equalsIgnoreCase("F")) {
            double convertedTemperature = fahrenheitToCelsius(temperature);
            System.out.println(convertedTemperature);
        } else {
            System.out.println("Loai nhiet do khong hop le");
        }

        scanner.close();
    }

    // Chuyển đổi từ độ C sang độ F
    public static double celsiusToFahrenheit(double celsius) {
        return celsius * 9 / 5 + 32;
    }

    // Chuyển đổi từ độ F sang độ C
    public static double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }

}

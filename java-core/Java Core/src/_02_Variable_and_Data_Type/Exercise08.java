package _02_Variable_and_Data_Type;

import java.util.Scanner;

public class Exercise08 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // In thông báo yêu cầu người dùng nhập một số nguyên dương
        System.out.print("Hãy nhập một số nguyên dương: ");

        // Nhập một số nguyên dương
        int number = scanner.nextInt();
        int sum = 0;

        // Tính tổng các ước số của số đó (không kể chính nó)
        for (int i = 1; i <= number / 2; i++) {
            if (number % i == 0) {
                sum += i;
            }
        }

        // Kiểm tra và in kết quả ra màn hình
        if (sum == number) {
            System.out.println(number + " là số hoàn hảo.");
        } else {
            System.out.println(number + " không phải là số hoàn hảo.");
        }

        scanner.close();
    }

}

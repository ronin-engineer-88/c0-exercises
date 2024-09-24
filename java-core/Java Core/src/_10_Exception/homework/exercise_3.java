package _10_Exception.homework;

import java.util.Scanner;

public class exercise_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num1 = 0, num2 = 0;

        try {
            System.out.print("Nhập số nguyên thứ nhất: ");
            num1 = Integer.parseInt(scanner.nextLine());

            System.out.print("Nhập số nguyên thứ hai: ");
            num2 = Integer.parseInt(scanner.nextLine());

            int sum = num1 + num2;
            System.out.println("Kết quả: " + num1 + " + " + num2 + " = " + sum);

        } catch (NumberFormatException e) {
            System.out.println("Lỗi: Vui lòng nhập đúng định dạng đúng số nguyên.");

        } finally {
            System.out.println("Chương trình kết thúc.");
            scanner.close();
        }
    }
}


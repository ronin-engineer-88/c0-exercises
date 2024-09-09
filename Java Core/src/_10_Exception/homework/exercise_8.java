package _10_Exception.homework;

import java.util.Scanner;

public class exercise_8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = 0;
        double result = 0;
        boolean flag = false;

        System.out.print("Nhập số nguyên n: ");
        n = scanner.nextInt();

         try {
            result = calculateSqrt(n);

         } catch (IllegalArgumentException ex) {
            System.out.println("Không thể tính căn bậc hai! Số của bạn không phải là số nguyên dương!");

         } finally {
             System.out.println("Kết quả căn bậc hai của " + n + " là: " + result);
         }

    }

    private static double calculateSqrt(int n) throws IllegalArgumentException {
        if(n < 0)
            throw new IllegalArgumentException();

        return java.lang.Math.sqrt(n);
    }
}

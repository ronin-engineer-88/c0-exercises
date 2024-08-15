package _05_Arrays_TextIO.homework;

import java.util.Scanner;

public class exercise_7 {
    public static long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // Hàm tính BSCNN (Bội số chung nhỏ nhất)
    public static long lcm(long a, long b) {
        return (a / gcd(a, b)) * b;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int test = scanner.nextInt();

        for (int i = 0; i < test; i++) {
            long a = scanner.nextLong();
            long b = scanner.nextLong();

            // Tính và in ra USCLN và BSCNN
            long uscln = gcd(a, b);
            long bscnn = lcm(a, b);

            System.out.println(uscln + " " + bscnn);
        }

        scanner.close();
    }
}
/*
input:
        2
        12 34
        1234 5678
output:
        2 204
        2 3503326
*/

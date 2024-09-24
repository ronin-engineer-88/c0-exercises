package _02_Variable_and_Data_Type;
import java.util.Scanner;

public class Exercise04 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhap so nguyen duong: ");
        int n = scanner.nextInt();

        if (n < 0) {
            System.out.println("Vui long nhap mot so nguyen duong.");
        } else {
            long factorial = calculateFactorial(n);
            System.out.println("Giai thua cua " + n + " la: " + factorial);
        }

        scanner.close();
    }

    public static long calculateFactorial(int n) { // hàm tính giai thừa.
        long result = 1;

        if (n == 0 || n == 1) {
            return 1;
        }
        for (int i = 2; i <= n; i++) {
            result *= i;
        }

        return result;
    }
}

/*
require: Viết chương trình tính giai thừa của một số n
*/
package _04_Loop_and_Function;

import java.util.Scanner;

public class Exercise07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap so nguyen n: ");
        int n = scanner.nextInt();

        System.out.print("So fibonacci thu " + n + " la: " + fibonacci(n));

        scanner.close();
    }

    private static int fibonacci(int n) {
        if(n == 1)
            return 1;
        if(n == 2)
            return 2;
        return fibonacci(n-1) + fibonacci(n-2);
    }
}

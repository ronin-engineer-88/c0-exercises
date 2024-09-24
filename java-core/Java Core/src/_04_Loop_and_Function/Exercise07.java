package _04_Loop_and_Function;

import java.util.Scanner;

public class Exercise07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap so nguyen duong n: ");
        int n = scanner.nextInt();

        while(n <= 0){
            System.out.print("n khong hop le. Vui long nhap lai: ");
            n = scanner.nextInt();
        }

        System.out.print("So fibonacci thu " + n + " la: " + fibonacci(n));

        scanner.close();
    }

    private static int fibonacci(int n) {
        if(n == 1 || n == 2)
            return 1;
        return fibonacci(n-1) + fibonacci(n-2);
    }
}

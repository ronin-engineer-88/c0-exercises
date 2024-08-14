package _04_Loop_and_Function;

import java.util.Scanner;

public class Exercise03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap so nguyen duong n: ");
        int n = scanner.nextByte();

        // Điều kiện n > 0, nếu n <= 0 thì nhập lại
        while(n <= 0) {
            System.out.print("n phai la so nguyen duong. Vui long nhap lai: ");
            n = scanner.nextInt();
        }

        System.out.println("Hinh A: "); shapeA(n);

        System.out.println("Hinh B: "); shapeB(n);

        System.out.println("Hinh C: "); shapeC(n);

        System.out.println("Hinh D: "); shapeD(n);

        scanner.close();
    }

    private static void shapeA(int n){
        for (int i = 1; i <= n; i++){
            for (int j = 0; j < i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
    private static void shapeB(int n){
        for (int i = n; i > 0; i--){
            for (int j = i; j > 0; j--){
                System.out.print("* ");
            }
            System.out.println();
        }
    }
    private static void shapeC(int n){
        int appearance = 1;
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                if (j < (n - appearance))
                    System.out.print("  ");
                else
                    System.out.print("* ");
            }
            appearance++;
            System.out.println();
        }
    }
    private static void shapeD(int n){
        int appearance = n;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j <= (n - appearance - 1))
                    System.out.print("  ");
                else
                    System.out.print("* ");
            }
            appearance--;
            System.out.println();
        }
    }
}

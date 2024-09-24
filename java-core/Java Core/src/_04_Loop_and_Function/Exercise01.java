package _04_Loop_and_Function;

import java.util.Scanner;

public class Exercise01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap so nguyen duong n tu 1 den 15: ");
        byte n = scanner.nextByte();

        // Điều kiện 0 < n < 15, nếu ở ngoài khoảng thì nhập lại
        while(n < 1 || n > 15) {
            System.out.print("Ngoai khoang [1,15]. Vui long nhap lai: ");
            n = scanner.nextByte();
        }


        for (byte i = n; i > 0; i--) {
            for (byte j = i; j > 0; j--){
                System.out.print(j + " ");
            }
            for(byte k = 1; k < i; k++) {
                System.out.print(k + 1 + " ");
            }
            System.out.println();
        }

        scanner.close();
    }
}

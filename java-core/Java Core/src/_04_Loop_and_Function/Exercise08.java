package _04_Loop_and_Function;

import java.util.Scanner;

public class Exercise08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập số n: ");
        int n = scanner.nextInt();

        System.out.println("Các số chính phương nhỏ hơn " + n + " là:");
        for (int i = 1; i * i < n; i++) {
            System.out.println(i * i);
        }
    }
}

// Liệt kê tất cả số chính phương nhỏ hơn n. Input là một số n - Output sẽ in ra danh sách số chính phương nhỏ hơn n
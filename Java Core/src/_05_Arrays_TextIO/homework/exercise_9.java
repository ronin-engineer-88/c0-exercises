package _05_Arrays_TextIO.homework;

import java.util.Scanner;

public class exercise_9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int test = scanner.nextInt();

        for (int i = 0; i < test; i++) {
            int n = scanner.nextInt();
            int count = 0;

            // Tìm các ước số của N
            for (int j = 1; j * j <= n; j++) {
                if (n % j == 0) {
                    if (j % 2 == 0) { // check nếu ước số chia hết cho 2
                        count++;
                    }
                    if (j != n / j && (n / j) % 2 == 0) {
                        count++;
                    }
                }
            }

            System.out.println(count);
        }

        scanner.close();
    }
}
/*
input:
        2
        9
        8
output:
        0
        3
/*/

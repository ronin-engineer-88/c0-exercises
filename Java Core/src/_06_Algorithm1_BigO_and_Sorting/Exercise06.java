package _06_Algorithm1_BigO_and_Sorting;

import java.util.Scanner;

public class Exercise06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int A = scanner.nextInt();
        int B = scanner.nextInt();
        int V = scanner.nextInt();

        int numsDay = (V-A)/(A - B);
        if((V-A)%(A - B) != 0)
            numsDay += 1;

        System.out.print(numsDay);
    }
}

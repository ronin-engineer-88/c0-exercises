package _06_Algorithm_Big_O_Sorting_Algorithms;

import java.util.Scanner;

public class exercise_6 {
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

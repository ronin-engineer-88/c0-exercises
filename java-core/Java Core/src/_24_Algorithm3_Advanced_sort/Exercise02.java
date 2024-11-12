package _24_Algorithm3_Advanced_sort;

import java.util.Scanner;

public class Exercise02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        if(checkIfCanSoldInOrder(arr))
            System.out.println("YES");
        else
            System.out.println("NO");

    }

    private static boolean checkIfCanSoldInOrder(int[] arr) {
        int count25 = 0;
        int count50 = 0;

        for (int bill : arr) {
            if (bill == 25) {
                count25++;
            } else if (bill == 50) {
                if (count25 > 0) {
                    count25--;
                    count50++;
                } else {
                    return false;
                }
            } else if (bill == 100) {
                if (count50 > 0 && count25 > 0) {
                    count50--;
                    count25--;
                } else if (count25 >= 3) {
                    count25 -= 3;
                } else {
                    return false;
                }
            }
        }

        return true;
    }

}



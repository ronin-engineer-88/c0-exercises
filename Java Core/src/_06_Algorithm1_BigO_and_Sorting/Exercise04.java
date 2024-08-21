package _06_Algorithm1_BigO_and_Sorting;

import java.util.Arrays;
import java.util.Scanner;

public class Exercise04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = scanner.nextInt();
        }

        System.out.println(findx(arr, k));
    }

    private static int findx(int[] arr, int k) {
        Arrays.sort(arr);
        if(arr[k] > arr[k-1])
            return arr[k-1];

        return -1;
    }
}

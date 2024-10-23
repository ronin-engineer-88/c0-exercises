package _22_Recursion;

import java.util.Scanner;

public class Exercise9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Nhập vào số lượng phần tử của dãy: ");
        int n = scanner.nextInt();
        
        int[] arr = new int[n];
        System.out.println("Nhập vào các phần tử của dãy:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        System.out.println("Các hoán vị của dãy số là:");
        permute(arr, 0, n - 1);
    }

    public static void permute(int[] arr, int start, int end) {
        if (start == end) {
            printArray(arr);
        } else {
            for (int i = start; i <= end; i++) {
                swap(arr, start, i);
                permute(arr, start + 1, end);
                swap(arr, start, i);
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void printArray(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}

package _06_Algorithm_Big_O_Sorting_Algorithms;

import java.util.Scanner;

public class exercise_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap so phan tu cua mang: "); int n = scanner.nextInt();


        int[] arr = new int[n];
        System.out.print("Nhap cac phan tu cua mang: ");
        for(int i = 0; i < n; i++){
            arr[i] = scanner.nextInt();
        }

        customizeSorted(arr);
        System.out.print("Ket qua: ");
        for(int i = 0; i < n; i++){
            System.out.print(arr[i] + " ");
        }

    }

    private static void customizeSorted(int[] arr) {
        for(int i = 0; i < arr.length-1; i+=2){
            int max = arr[i];
            int min = arr[i+1];
            if(arr[i+1] > arr[i]){
                arr[i] = arr[i+1];
                arr[i+1] = max;
                max = arr[i];
                min = arr[i+1];
            }
            for(int j = i+2; j < arr.length; j++){
                if(arr[j] > max){
                    arr[i] = arr[j];
                    arr[j] = max;
                    max = arr[i];
                } else if(arr[j] < min) {
                    arr[i+1] = arr[j];
                    arr[j] = min;
                    min = arr[i+1];
                }
            }
            if(i + 1 == arr.length)
                break;
        }
    }
}

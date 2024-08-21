package _06_Algorithm1_BigO_and_Sorting;

import java.util.Scanner;

public class Exercise08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] arr = new int[4];
        for(int i = 0; i <arr.length; i++){
            arr[i] = scanner.nextInt();
        }

        System.out.print(requiredDiffNumNeed(arr));

    }

    private static int requiredDiffNumNeed(int[] arr) {
        int[] nonDuplicateNum = new int[arr.length];
        int count = 0;
        for(int i = 0; i < arr.length; i++){
            if(indexOf(nonDuplicateNum, arr[i]) == -1){
                nonDuplicateNum[count] = arr[i];
                count++;
            }
        }

        return (4 - count);
    }

    private static int indexOf(int[] arr, int n){
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == n)
                return i;
        }
        return -1;
    }
}

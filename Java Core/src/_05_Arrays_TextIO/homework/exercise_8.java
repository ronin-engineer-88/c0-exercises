package _05_Arrays_TextIO.homework;

import java.util.Scanner;

public class exercise_8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap so lan test: "); int t = scanner.nextInt();

        for(int i = 0; i < t; i++){
            System.out.print("Nhap so luong phan tu cua mang: "); int n = scanner.nextInt();
            int[] arr = new int[n];
            System.out.print("Nhap phan tu cua mang: ");
            for(int j = 0; j < n; j++){
                arr[j] = scanner.nextInt();
            }

            Integer foundElement = findIterativeNumberWithLowestIndex(arr);
            if(foundElement == null)
                System.out.println("NO");
            else
                System.out.println(foundElement);

        }
    }

    private static Integer findIterativeNumberWithLowestIndex(int[] arr) {
        int[] nonDuplicateElement = new int[arr.length];
        int[] duplicateElement = new int[arr.length];
        int count1 = 0, count2 = 0;

        for(int i = 0; i < arr.length; i++){
            int index = indexOf(nonDuplicateElement, arr[i]);
            if(index == -1){
                nonDuplicateElement[count1] = arr[i];
                count1++;
            } else {
                if(indexOf(duplicateElement, arr[i]) == -1)
                    duplicateElement[count2] = arr[i];
                count2++;
            }
        }

        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < duplicateElement.length; j++){
                if(arr[i] == duplicateElement[j]){
                    return arr[i];
                }
            }
        }

        return null;
    }

    private static int indexOf(int[] arr, int n){
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == n)
                return i;
        }
        return -1;
    }
}

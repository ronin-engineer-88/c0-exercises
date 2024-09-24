package _06_Algorithm_Big_O_Sorting_Algorithms;

import java.util.Arrays;

public class exercise_3 {
    public static void main(String[] args) {
        int[] array1 = {1, 3, 5, 7};
        int[] array2 = {2, 4, 6, 8, 10};

        int[] mergedArray = mergeArrays(array1, array2); // trộn 2 mảng

        System.out.println("Mảng sau khi trộn: " + Arrays.toString(mergedArray));
    }

    public static int[] mergeArrays(int[] array1, int[] array2) {  // merge sort
        int n1 = array1.length;
        int n2 = array2.length;
        int[] newArr = new int[n1 + n2];

        int i = 0, j = 0, k = 0;

        while (i < n1 && j < n2) {
            if (array1[i] <= array2[j]) {
                newArr[k++] = array1[i++];
            } else {
                newArr[k++] = array2[j++];
            }
        }

        while (i < n1) {
            newArr[k++] = array1[i++];
        }

        while (j < n2) {
            newArr[k++] = array2[j++];
        }

        return newArr;
    }
}

// Trộn 2 mảng đã sắp xếp thành một mảng cũng được sắp xếp
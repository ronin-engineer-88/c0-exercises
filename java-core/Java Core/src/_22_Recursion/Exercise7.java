package _22_Recursion;

public class Exercise7 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6}; 
        int result = sumEven(arr, 0);
        System.out.println("Tổng các số chẵn trong mảng là: " + result);
    }

    public static int sumEven(int[] arr, int index) {
        if (index == arr.length) {
            return 0;
        }

        if (arr[index] % 2 == 0) {
            return arr[index] + sumEven(arr, index + 1);

        } else {
            return sumEven(arr, index + 1);
        }
    }
}

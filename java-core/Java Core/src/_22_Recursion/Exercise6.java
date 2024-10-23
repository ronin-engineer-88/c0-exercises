package _22_Recursion;

public class Exercise6 {
    public static void main(String[] args) {
        
        int[] arr = {3, 5, 1, 7, 2};
        System.out.println(findMin(arr, 0)); // Output: 1

    }

    public static int findMin(int[] arr, int index) {
        if (index == arr.length - 1) {
            return arr[index];
        }
        return Math.min(arr[index], findMin(arr, index + 1));
    }

}

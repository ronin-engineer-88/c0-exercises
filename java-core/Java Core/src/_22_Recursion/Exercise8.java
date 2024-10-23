package _22_Recursion;

public class Exercise8 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 2, 1};
        System.out.println(isPalindrome(arr, 0, arr.length - 1));

    }   

    public static boolean isPalindrome(int[] arr, int left, int right) {
        if (left >= right) {
            return true;
        }
        if (arr[left] != arr[right]) {
            return false;
        }
        return isPalindrome(arr, left + 1, right - 1);
    }

}

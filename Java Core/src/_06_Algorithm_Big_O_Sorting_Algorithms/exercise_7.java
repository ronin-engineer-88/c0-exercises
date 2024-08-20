package _06_Algorithm_Big_O_Sorting_Algorithms;

public class exercise_7 {
    public static void main(String[] args) {
        int n = 3; // giày đỏ
        int m = 1; // giày xanh

        int daysDifferent = Math.min(n, m);

        int remainingRed = n - daysDifferent;
        int remainingBlue = m - daysDifferent;
        int daysSameColor = (remainingRed + remainingBlue) / 2;

        System.out.println(daysDifferent + " " + daysSameColor);
    }
}

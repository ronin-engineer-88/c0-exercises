package _22_Algorithm2_Recursion_and_Linear_Search;

public class Exercise1 {
    public static void main(String[] args) {
        int x = 2, n = 5;
        System.out.println(power(x, n));

    }

    public static int power(int x, int n) {

        if (n == 0) {
            return 1;
        }

        return x * power(x, n - 1);
    }

}

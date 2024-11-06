package _22_Algorithm2_Recursion_and_Linear_Search;

public class Exercise2 {
    public static void main(String[] args) {
        
        int n = 5;
        System.out.println("2^" + n + " = " + powerOfTwo(n));
    }

    public static int powerOfTwo(int n) {

        if (n == 0) {
            return 1;
        }
        
        return 2 * powerOfTwo(n - 1);
    }
}



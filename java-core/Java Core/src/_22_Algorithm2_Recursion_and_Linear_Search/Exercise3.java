package _22_Algorithm2_Recursion_and_Linear_Search;

public class Exercise3 {
    public static void main(String[] args) {
        int n = 5; 
        System.out.println("Tổng S(" + n + ") = " + sum(n));
    }   

    public static int sum(int n) {
        
        if (n == 1) {
            return 1;
        }
        
        return n + sum(n - 1);
    }
}

package _04_Loop_and_Function;

import java.util.Scanner;

import static java.lang.Math.pow;

public class Exercise09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap vao so i: ");
        long i = scanner.nextLong();

        System.out.println("So pi gan dung voi i = " + i + " la: " + evaluatePi(i));

        scanner.close();
    }

    public static double evaluatePi(long i){
        double sum = 0.0;
        for(int j = 1; j <= i; j++){
            sum += pow(-1, j+1) / (2.0*j - 1);
        }

        return 4*sum;
    }
}

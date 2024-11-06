package _24_Algorithm3_Advanced_sort;

import java.math.BigInteger;
import java.util.Scanner;

public class Exercise08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        BigInteger[] testcaseList = new BigInteger[t];
        for(byte i = 0; i < t; i++) {
            testcaseList[i] = scanner.nextBigInteger();
        }

        for(int i = 0; i < t; i++) {
            if(isDivisibleBy36(testcaseList[i]))
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }

    public static boolean isDivisibleBy36(BigInteger k) {
        return (k.mod(BigInteger.valueOf(36)).equals(BigInteger.ZERO));
    }
}

package _24_Algorithm3_Advanced_sort;

import java.util.Scanner;

public class Exercise04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();

        System.out.println(countPair(s));
    }

    public static int countPair(String s) {
        int result = 0;
        int indexValue2 = 0;

        for (int i = s.length() - 1; i > 0; i--) {
            if(s.charAt(i) - '0' == 2)
                indexValue2++;
            else if (s.charAt(i) - '0' == 1)
                result += indexValue2;
        }

        return result;
    }
}

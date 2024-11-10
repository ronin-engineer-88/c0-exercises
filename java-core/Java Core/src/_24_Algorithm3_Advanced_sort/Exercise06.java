package _24_Algorithm3_Advanced_sort;

import java.util.Scanner;

public class Exercise06 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        if(checkIfCorrectWithout0(a, b))
            System.out.println("YES");
        else
            System.out.println("NO");
    }

    public static Boolean checkIfCorrectWithout0 (int a, int b) {

        int a_ = remove0(a);
        int b_ = remove0(b);

        return a_ + b_ == remove0(a + b);
    }

    public static int remove0(int a) {
        String s = String.valueOf(a);
        StringBuilder result = new StringBuilder();

        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) != '0')
                result.append(s.charAt(i));
        }

        return Integer.parseInt(result.toString());
    }

}

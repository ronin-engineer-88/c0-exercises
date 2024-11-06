package _22_Algorithm2_Recursion_and_Linear_Search;

public class Exercise4 {
    public static void main(String[] args) {
        int n = 10;
        String binary1 = decimalToBinary(n);
        System.out.println(binary1.isEmpty() ? "0" : binary1);
        
        String binary2 = "1010";
        System.out.println(binaryToDecimal(binary2, 0));

    }

    public static String decimalToBinary(int n) {

        if (n == 0) {
            return "";
        }

        return decimalToBinary(n / 2) + (n % 2);
    }

    public static int binaryToDecimal(String binary, int index) {

        if (index == binary.length()) {
            return 0;
        }

        int digit = binary.charAt(binary.length() - 1 - index) - '0';

        return digit * (int) Math.pow(2, index) + binaryToDecimal(binary, index + 1);
    }


    
}

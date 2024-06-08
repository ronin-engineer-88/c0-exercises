package _03_1;

public class example_1_9 {
    // Toán tử thao tác với bit
    public static void main(String[] args) {
        int a = 5; //  nhị phân: 0101
        int b = 3; //  nhị phân: 0011

        // AND Bitwise
        int andResult = a & b; // 0101 & 0011 = 0001
        System.out.println("AND Bitwise Result: " + andResult); // Kết quả: 1

        // OR Bitwise
        int orResult = a | b; // 0101 | 0011 = 0111
        System.out.println("OR Bitwise Result: " + orResult); // Kết quả: 7

        // XOR Bitwise (chỉ một trong hai)
        int xorResult = a ^ b; // 0101 ^ 0011 = 0110
        System.out.println("XOR Bitwise Result: " + xorResult); // Kết quả: 6

        // NOT Bitwise (đảo ngược)
        int notResultA = ~a; // ~0101 = 1010 (nghịch đảo bit)
        int notResultB = ~b; // ~0011 = 1100 (nghịch đảo bit)
        System.out.println("NOT Bitwise Result for a: " + notResultA); // Kết quả: -6
        System.out.println("NOT Bitwise Result for b: " + notResultB); // Kết quả: -4

        // dịch trái
        int leftShiftResult = a << 1; // 0101 << 1 = 1010
        System.out.println("Left Shift Bitwise Result: " + leftShiftResult); // Kết quả: 10

        // dịch phải
        int rightShiftResult = a >> 1; // 0101 >> 1 = 0010
        System.out.println("Right Shift Bitwise Result: " + rightShiftResult); // Kết quả: 2
    }
}

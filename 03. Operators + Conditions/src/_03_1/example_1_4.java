package _03_1;

public class example_1_4 {
    // Toán tử so sánh
    public static void main(String[] args) {
        int a = 12;
        int b = 5;

        System.out.printf("\n %d == %d is %b", a, b , a == b); // 12 == 5 is false
        System.out.printf("\n %d != %d is %b", a, b , a != b); // 12 != 5 is true
        System.out.printf("\n %d < %d is %b", a, b , a < b);   // 12 < 5 is false
        System.out.printf("\n %d > %d is %b", a, b , a > b);   // 12 > 5 is true
        System.out.printf("\n %d <= %d is %b", a, b , a <= b); // 12 <= 5 is false
        System.out.printf("\n %d >= %d is %b", a, b , a >= b); // 12 >= 5 is true
    }
}

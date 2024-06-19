package _03_Operators_Conditions._03_1;

public class example_1_7 {
    // Toán tử ép kiểu
    public static void main(String[] args) {

        // C1. Ép kiểu ngầm định
        int intVariable = 25;
        long longVariable = intVariable;
        float floatVariable = longVariable;
        double doubleVariable = floatVariable;

        System.out.println("Integer value is: " + intVariable); // Integer value is: 25
        System.out.println("Long value is: " + longVariable); // Long value is: 25
        System.out.println("Float value is: " + floatVariable); // Float value is: 25.0
        System.out.println("Double value is: " + doubleVariable); // Double value is: 25.0

        // C2. Ép kiểu tường minh
        // ví dụ: ép kiểu từ số nguyên sang số thực
        int a = 2;
        double b = (double) a;
        System.out.println("Giá trị của a = " + a); // Giá trị của a = 2
        System.out.println("Giá trị của b = " + b); // Giá trị của b = 2.0
    }
}

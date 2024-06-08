package _03_1;

public class example_1_3 {
    // Toán tử gán
    public static void main(String[] args) {
        int a = 12;
        int b = 5;

        System.out.println("Giá trị biến a là: " + a); // Giá trị biến a là: 12
        System.out.println("Giá trị biến b là: " + b); // Giá trị biến b là: 5

        int c = a;
        System.out.println("Giá trị biến c sau khi gán c = a là: " + c); // Giá trị biến c sau khi gán c = a là: 12

        c += b; // c = c + b
        System.out.println("Giá trị biến c sau khi cộng và gán c += b là: " + c); // Giá trị biến c sau khi cộng và gán c += b là: 17

    }
}

package homework;

public class exercise_5 {
    public static void main(String[] args) {
        double a = 3;
        double b = 5;

        calculatePerimeter(a,b); // hàm tính chu vi hình chữ nhật
        calculateArea(a, b);     // hàm tính diện tích hình chữ nhâ
    }

    public static double calculatePerimeter(double a, double b) {
        double result = 2 * (a + b);
        System.out.println("Chu vi của hình chữ nhật là: " + result);

        return result;
    }

    public static double calculateArea(double a, double b) {
        double result = a * b;
        System.out.println("Diện tích của hình chữ nhật là: " + result);

        return result;
    }
}
/*
Requirment: Cho a và b là hai cạnh của hình chữ nhật và tính chu vi và diện tích của hình chữ nhật đó.
            Hiển thị kết quả lên màn hình.
*/
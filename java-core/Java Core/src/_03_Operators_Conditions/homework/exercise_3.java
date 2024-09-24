package _03_Operators_Conditions.homework;

public class exercise_3 {


    public static void main(String[] args) {
        int a = 15;
        int b = 3;

        calculate(a, b);
    }

    private static void calculate(int a, int b) {
        int sum = a + b;
        System.out.println("Tổng 2 số: " + sum);

        int difference = a - b;
        System.out.println("Hiệu 2 số: " + difference);

        int product = a * b;
        System.out.println("Tích 2 số: " + product);

        if (b != 0) { // kiểm tra nếu mẫu khác 0
            double quotient = (double) a / b;
            System.out.println("Thương: " + quotient);
        } else {
            System.out.println("Không thể chia cho 0");
        }
    }
}

/*
Requirment: Cho hai số nguyên a, b. In ra màn hình tổng, hiệu, tích, thương của chúng.
            Lưu ý khi xử lý phép chia sẽ cần ép kiểu, kiểm tra mẫu khác 0.
            Xuất kết quả ra màn hình.
*/
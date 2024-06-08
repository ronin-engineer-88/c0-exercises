package homework;

public class exercise_4 {
    public static void main(String[] args) {
        int a = 2;
        int b = 3;

        // hàm so sánh 2 số nguyên
        compare(a, b);  // sử dụng if-else
        compare1(a, b); // sử dụng toán tử 3 ngôi
    }

    public static void compare(int a, int b) {
        if (a > b) {
            System.out.println(+ a + " > " + b);
        } else if (a < b) {
            System.out.println(a + " < " + b);
        } else {
            System.out.println(a + " = " + b);
        }
    }

    public static void compare1(int a, int b) {
        String result = a > b ?  a + " > " + b :
                        a < b ?  a + " < " + b :
                                 a + " = " + b;
        System.out.println(result);
    }
}

/*
Requirment: Cho hai số nguyên a, b. So sánh xem số nào lớn hơn, số nào nhỏ hơn hay hai số bằng nhau. In kết quả ra màn hình.
*/
package _03_Operators_Conditions.homework;

public class exercise_6 {
    public static void main(String[] args) {
        double a = 3, b = 4, c = 5;

        String result = checkTriangle(a, b, c) ? "YES" : "NO";
        System.out.println(result);
    }

    // hàm kiểm tra 3 cạnh có phải là 1 tam giác ko.
    public static boolean checkTriangle(double a, double b, double c) {
        if (a <= 0 || b <= 0 || c <= 0) { // check điều kiện các cạnh 1 tam giác
            return false;
        }

        if (a + b > c && a + c > b && b + c > a) { // check điều kiện tam giác
            return true;
        }

        return false;
    }
}

/*
Requirment: Cho a, b và c là 3 số thực bất kỳ.
            Kiểm tra xem 3 số đó có thể là 3 cạnh của một tam giác không.
            Nếu có in ra màn hình là “YES", nếu không thì in “NO”.
*/
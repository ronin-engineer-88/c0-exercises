package _04_Loop_and_Function;

public class Exercise04 {
    public static void main(String[] args) {
        for (int i = 2; i <= 9; i++) {
            System.out.println("Bảng chia " + i + ":");
            for (int j = 1; j <= 10; j++) {
                double result = (double) i / j;
                System.out.printf("%d / %d = %.2f%n", i, j, result);
            }
            System.out.println();
        }
    }
}

// Sử dụng vòng lặp để hiển bảng cửu chương chia như hình
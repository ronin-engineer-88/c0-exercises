package _05_Arrays_TextIO.homework;

public class exercise_1 {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6};  // Khởi tạo mảng

        int sum = 0; // khoiwt tạo biến lưu tổng giá trị
        for (int number : array) {
            sum += number;
        }

        System.out.println("Tổng các phần tử trong mảng là: " + sum);
    }
}

// Requirment: Nhập vào một mảng, và tính tổng các số có trong mảng đó.



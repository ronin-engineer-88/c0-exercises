package _05_Arrays_TextIO.homework;

public class exercise_3 {
    public static void main(String[] args) {
        int[][] array = {
                {2, 4, 6},
                {8, 10, 12},
                {14, 16, 18}
        }; // Khởi tạo mảng hai chiều.

        int max = findMax(array);
        System.out.println("Phần tử lớn nhất trong mảng hai chiều là: " + max);
    }

    public static int findMax(int[][] array) {
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < array.length; i++) {        // duyệt từng hàng trong mảng
            for (int j = 0; j < array[i].length; j++) { // duyệt từng cột của mảng
                if (array[i][j] > max) {
                    max = array[i][j]; // update giá trị lớn nhất.
                }
            }
        }

        return max;
    }
}

// Requirment: Nhập vào một mảng hai chiều, Trả về phần tử lớn nhất có trong mảng hai chiều.
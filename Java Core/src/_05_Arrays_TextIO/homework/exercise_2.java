package _05_Arrays_TextIO.homework;

public class exercise_2 {
    public static void main(String[] args) {
        int[] array = {1, 4, 5, 8, 10, 15};
        int n = 5;  // số nguyên cần tìm index.

        int index = findIndex(array, n); // Hàm tìm index của số nguyên n
        if (index != -1) {
            System.out.println("Chỉ số của phần tử " + n + " trong mảng là: " + index);
        } else {
            System.out.println("Không tìm thấy phần tử " + n + " trong mảng.");
        }
    }

    public static int findIndex(int[] array, int n) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == n) {
                return i;
            }
        }

        return -1;
    }
}

// Requirment:  Nhập vào một mảng và số nguyên n. Trả về index của số nguyên n có trong mảng, nếu không có trả về -1.
// idea: sử dụng vòng for.... (các bạn nên tìm hiểu các cách khác để thực hành, so sánh xem cách nào tối ưu hơn).
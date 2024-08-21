package _06_Algorithm_Big_O_Sorting_Algorithms;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class exercise_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập số lượng phần tử trong mảng: ");
        int n = scanner.nextInt();

        int[] array = new int[n];
        System.out.println("Nhập các phần tử của mảng:");
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }

        // Sử dụng HashMap để lưu trữ số lần xuất hiện của các phần tử
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : array) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        System.out.println("Giá trị và số lần xuất hiện:");
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            System.out.println(entry.getKey() + " xuất hiện " + entry.getValue() + " lần");
        }
    }
}

 // Bài toán yêu cầu các bạn liệt kê các giá trị xuất hiện trong mảng kèm theo số lần xuất hiện của nó.
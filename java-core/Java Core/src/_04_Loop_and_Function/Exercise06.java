package _04_Loop_and_Function;

import java.util.Scanner;

public class Exercise06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số lượng phần tử trong dãy: ");
        int n = scanner.nextInt();

        if (n < 2) {
            System.out.println("Dãy phải có ít nhất hai phần tử.");
            return;
        }

        int[] array = new int[n];
        System.out.println("Nhập các phần tử của dãy:");
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }

        int secondLargest = findSecondNumber(array);
        if (secondLargest == Integer.MIN_VALUE) {
            System.out.println("Không tìm thấy số lớn thứ hai (phần tử đều giống nhau).");
        } else {
            System.out.println("Số lớn thứ hai trong dãy là: " + secondLargest);
        }
    }

    public static int findSecondNumber(int[] arr) {
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int num : arr) {
            if (num > largest) {
                secondLargest = largest;
                largest = num;
            } else if (num > secondLargest && num < largest) {
                secondLargest = num;
            }
        }

        return secondLargest;
    }
}

// Viết một chương trình tìm số lớn thứ 2 trong dãy. input là một dãy cần tìm, output là số lớn thứ 2 trong dãy

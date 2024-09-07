package _12_Data_structure;

import java.util.Scanner;
import java.util.Stack;

public class exercise_7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập số nguyên dương (cơ số 10): ");
        int decimalNumber = sc.nextInt();

        Stack<Integer> stack = new Stack<>();
        while (decimalNumber > 0) { // Xử lý chuyển từ cơ số 10 sang cơ số 2
            int remainder = decimalNumber % 2;
            stack.push(remainder);  // Lưu phần dư vào stack
            decimalNumber = decimalNumber / 2;  // Chia cho 2
        }

        System.out.print("Giá trị nhị phân: ");
        while (!stack.isEmpty()) {
            System.out.print(stack.pop());  // Lấy phần tử ra và in theo thứ tự ngược lại
        }

        sc.close();
    }
}

package _10_Exception.homework;

import java.util.InputMismatchException;
import java.util.Scanner;

public class exercise_4 {
    public static void main(String[] args) {
        int[] arr = new int[10000];
        int i = 0, n = 0;
        boolean isValid = false;
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập vào chỉ số mảng: ");

        while(!isValid) {
            try {
                i = scanner.nextInt();
                arr[i] = n;
                isValid = true;

            } catch (InputMismatchException ex){
                isValid = false;
                scanner.next();
                System.out.print("Chỉ số nhập vào phải là một số nguyên! Vui lòng nhập lại chỉ số mảng: ");

            } catch (ArrayIndexOutOfBoundsException ex) {
                isValid = false;
                System.out.print("Chỉ số nhập vào vượt quá giới hạn mảng! Vui lòng nhập lại: ");
            }

        }

        System.out.print("Nhập giá trị gán cho phần tử vừa nhập: ");
        n = scanner.nextInt();
        arr[i] = n;

        System.out.println("Giá trị tại phần tử " + i + " của mảng là: " + arr[i]);
        scanner.close();
    }
}

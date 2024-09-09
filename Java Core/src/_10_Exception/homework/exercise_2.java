package _10_Exception.homework;

import java.util.InputMismatchException;
import java.util.Scanner;

public class exercise_2 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean isValid = false;
        int n = 0;

        System.out.print("Nhập vào một số nguyên: ");

        do {
            try {
                n = scanner.nextInt();
                isValid = true;

            } catch (InputMismatchException e) {
                isValid = false;
                scanner.next();
                System.out.println("Số vừa nhập không phải là số nguyên!");
                System.out.print("Vui lòng nhập lại: ");
            }

        } while(!isValid);

        scanner.close();


    }


}

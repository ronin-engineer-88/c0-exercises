package _10_Exception.homework.exercise_6;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)  {
        Scanner scanner = new Scanner(System.in);
        int n = 0;
        boolean flag = false;

        System.out.print("Nhập vào số nguyên dương: ");

        while(!flag){
            try {
                n = positiveIntegerInput(scanner);
                flag = true;

            } catch (NegativeNumberException e) {
                flag = false;
                System.out.println(e.getMessage());
                System.out.print("Nhập lại: ");
            } catch (InputMismatchException ex) {
                scanner.next();
                System.out.print("Vui lòng nhập số nguyên: ");
            }
        }

        System.out.print("Số của bạn là: " + n);
    }

    private static int positiveIntegerInput(Scanner scanner) throws NegativeNumberException {
        try {
            int n = scanner.nextInt();
            if(n <= 0){
                throw new NumberFormatException("Số bạn nhập phải là số dương!");
            }
            return n;

        } catch (NumberFormatException ex){
            throw new NegativeNumberException("Lỗi: " + ex.getMessage());
        }

    }
}

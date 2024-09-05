package _10_Exception.homework;

import java.util.Scanner;

public class exercise_5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Nhập tuổi của bạn: ");
            int age = scanner.nextInt();
            validateAge(age);
            System.out.println("Tuổi của bạn hợp lệ: " + age);

        } catch (InvalidAgeException e) {
            System.out.println("Error : " + e.getMessage());
        } finally {
            scanner.close();
        }
    }

    public static void validateAge(int age) throws InvalidAgeException {
        if (age < 18) {
            throw new InvalidAgeException("Tuổi của bạn phải lớn hơn hoặc bằng 18.");
        }
    }

    public static class InvalidAgeException extends Exception {
        public InvalidAgeException(String message) {
            super(message);
        }
    }
}



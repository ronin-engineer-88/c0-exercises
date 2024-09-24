package _04_Loop_and_Function;

import java.util.Scanner;

public class Exercise02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập chuỗi:");
        String input = scanner.nextLine().toLowerCase();

        int vowelCount = 0;
        int consonantCount = 0;

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                    vowelCount++;
                } else {
                    consonantCount++;
                }
            }
        }

        System.out.println("The number of vowels is " + vowelCount);
        System.out.println("The number of consonants is " + consonantCount);
    }
}

/*
   Tính số lượng nguyên âm/Phụ âm trong một chuỗi ký tự. Input là một chuỗi String.
   Giả sử Input là  “Programming is fun” thì output sẽ in ra như sau:
        The number of vowels is 5
        The number of consonants is 11

*/


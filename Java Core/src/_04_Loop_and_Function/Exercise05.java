package _04_Loop_and_Function;

import java.util.Scanner;

public class Exercise05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap vao day 12 so: ");
        String ISBM12Sequences = scanner.next();

        while(ISBM12Sequences.length() != 12){
            System.out.print("Day khong hop le. Vui long nhap lai: ");
            ISBM12Sequences = scanner.next();
        }

        System.out.println("So ISBN-13: " + ISBM12Sequences + checksum(ISBM12Sequences));

        scanner.close();

    }

    private static int checksum(String ISBM12){
        int sum = 0;
        for (int i = 0; i < ISBM12.length(); i++){
            if (i % 2 == 0)
                sum += (ISBM12.charAt(i) - '0');
            else
                sum += 3*(ISBM12.charAt(i) - '0');
        }

        int checksum = 10 -sum%10;
        if (checksum == 10)
            checksum = 0;

        return checksum;

    }
}

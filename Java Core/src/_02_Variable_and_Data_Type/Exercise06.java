/**
 * Hãy lập trình nhập 1 số nguyên dương nhỏ hơn 1000 và đổi sang số La mã tương ứng, in kết quả ra màn hình.
 */

package _02_Variable_and_Data_Type;

import java.util.Scanner;

public class Exercise06 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // In thông báo yêu cầu người dùng nhập một số nguyên dương nhỏ hơn 1000
        System.out.print("Hãy nhập một số nguyên dương nhỏ hơn 1000: ");

        // Nhập một số nguyên dương nhỏ hơn 1000
        int number = scanner.nextInt();

        // Kiểm tra xem số có hợp lệ không
        if (number <= 0 || number >= 1000) {
            System.out.println("Số nhập vào phải là số nguyên dương nhỏ hơn 1000");
        } else {
            // Chuyển đổi số thành số La Mã
            String romanNumeral = "";
            int tempNumber = number;

            // Xử lý hàng trăm
            if (tempNumber >= 900) {
                romanNumeral += "CM";
                tempNumber -= 900;
            } else if (tempNumber >= 500) {
                romanNumeral += "D";
                tempNumber -= 500;
            } else if (tempNumber >= 400) {
                romanNumeral += "CD";
                tempNumber -= 400;
            } else {
                while (tempNumber >= 100) {
                    romanNumeral += "C";
                    tempNumber -= 100;
                }
            }

            // Xử lý hàng chục
            if (tempNumber >= 90) {
                romanNumeral += "XC";
                tempNumber -= 90;
            } else if (tempNumber >= 50) {
                romanNumeral += "L";
                tempNumber -= 50;
            } else if (tempNumber >= 40) {
                romanNumeral += "XL";
                tempNumber -= 40;
            } else {
                while (tempNumber >= 10) {
                    romanNumeral += "X";
                    tempNumber -= 10;
                }
            }

            // Xử lý hàng đơn vị
            if (tempNumber == 9) {
                romanNumeral += "IX";
                tempNumber -= 9;
            } else if (tempNumber >= 5) {
                romanNumeral += "V";
                tempNumber -= 5;
            } else if (tempNumber == 4) {
                romanNumeral += "IV";
                tempNumber -= 4;
            } else {
                while (tempNumber >= 1) {
                    romanNumeral += "I";
                    tempNumber -= 1;
                }
            }

            // In kết quả ra màn hình
            System.out.println("Số La Mã tương ứng là: " + romanNumeral);
        }

        scanner.close();
    }


}

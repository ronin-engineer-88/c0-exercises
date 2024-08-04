package _02_Variable_and_Data_Type;
import java.util.Scanner;

public class Exercise10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the amount to withdraw: ");
        int amount = scanner.nextInt();

        calculateBanknotes(amount);

        scanner.close();
    }

    public static void calculateBanknotes(int amount) {
        int[] denominations = {500, 200, 100, 20, 10, 5, 2, 1};
        int total = 0;

        for (int denomination : denominations) {
            int count = amount / denomination;
            if (count > 0) {
                System.out.println(denomination + " VND: " + count + " bills");
                total += count;
                amount %= denomination;
            }
        }

        System.out.println("Total number of sheets: " + total);
    }
}

/*
require: Một người cần rút một số tiền T từ ngân hàng và muốn tổng số tờ ít nhất.
         Cho biết có các loại tiền mệnh giá 500, 200, 100, 20, 10, 5, 2 và 1.
         Nhập từ bàn phím số tiền T và in ra số tờ mỗi loại mệnh giá và tổng số tờ nhận được.
*/

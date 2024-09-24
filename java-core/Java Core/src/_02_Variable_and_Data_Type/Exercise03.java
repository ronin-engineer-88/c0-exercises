package _02_Variable_and_Data_Type;

import java.util.Scanner;

public class Exercise03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.print("Enter times you want to convert (minutes): "); int m = scanner.nextInt();

        // Chuyển đổi sang dạng giờ và phút
        int hours = m/60;
        int minutes = m - hours*60;

        // Chuyển đổi số ngày và giờ còn lại
        int days = hours/24;
        hours = hours - days*24; // Tính số giờ còn lại (Nếu hours > 24)

        // Chuyển đổi số năm và ngày còn lại
        int years = days/365;
        days = days - years*365; // Tính số ngày còn lại (Nếu days > 365)

        System.out.print("Result: " + years + " years " + days + " days "
                                    + hours + " hours " + minutes + " minutes." );
    }
}

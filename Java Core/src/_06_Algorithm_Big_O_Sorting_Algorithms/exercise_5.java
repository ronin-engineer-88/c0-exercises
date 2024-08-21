package _06_Algorithm_Big_O_Sorting_Algorithms;

import java.util.Scanner;

public class exercise_5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Nhập số lượng khách hàng
        int n = scanner.nextInt();
        int count25 = 0, count50 = 0;

        for (int i = 0; i < n; i++) {
            int bill = scanner.nextInt();

            switch (bill) {
                case 25:
                    count25++;
                    break;
                case 50:
                    if (count25 > 0) { // Khi khách trả 50k, cần trả lại 25k
                        count25--;
                        count50++;
                    } else {
                        System.out.println("NO");
                        return;
                    }
                    break;
                case 100:
                    if (count50 > 0 && count25 > 0) {  // Khi khách trả 100k, cần trả lại 75k
                        count50--;
                        count25--;
                    } else if (count25 >= 3) {
                        count25 -= 3;
                    } else {
                        // Không đủ tiền lẻ để trả lại, in "NO" và kết thúc
                        System.out.println("NO");
                        return;
                    }
                    break;
                default:
                    // Trường hợp không hợp lệ (mệnh giá không phải 25, 50, 100)
                    System.out.println("NO");
                    return;
            }
        }

        // Nếu không gặp vấn đề nào, in "YES"
        System.out.println("YES");
    }
}

/*
    Bộ phim “Fast And Furious 9” vừa được phát hành! Hiện tại có N khách hàng đang đứng xếp hàng để mua vé.
        Mỗi người trong số họ có 1 đúng tờ tiền mệnh giá 25k hoặc 50k hoặc 100k.
        Okami là nhân viên bán vè ở rạp chiếu phim CGV. Do sơ suất nên anh ta đã
        quên mất mã két nên không có tiền để trả lại khách.
*/

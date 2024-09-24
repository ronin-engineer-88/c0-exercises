package _03_Operators_Conditions._03_2;

public class example_2_6 {
    // Câu điều kiện Switch Case
    public static void main(String[] args) {
        int day = 5;
        switch (day) {
            case 1: {
                System.out.println("Chủ nhật");
                break;
            }
            case 2: {
                System.out.printf("\n Thứ %d", day);
                break;
            }
            case 3: {
                System.out.printf("\n Thứ %d", day);
                break;
            }
            case 4: {
                System.out.printf("\n Thứ %d", day);
                break;
            }
            case 5: { // Case này được thực hiện vì day = 5
                System.out.printf("\n Thứ %d", day);
                break;
            }
            case 6: {
                System.out.printf("\n Thứ %d", day);
                break;
            }
            case 7: {
                System.out.printf("\n Thứ %d", day);
                break;
            }
            default: {
                System.out.println("Ngày không hợp lệ");
            }
        }
    }
}

/* requirment:
       Viết một chương trình Java để xác định và in ra màn hình ngày trong tuần dựa trên một số nguyên từ 1 đến 7,
        trong đó 1 đại diện cho Chủ Nhật và 7 đại diện cho Thứ Bảy.
       Nếu ngày không phải là một số trong khoảng [1, 7] thì in ra màn hình dòng chữ “Ngày không hợp lệ”.
*/
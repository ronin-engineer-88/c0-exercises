package _03_Operators_Conditions._03_2;

public class example_2_4 {
    // Câu điều kiện rẽ nhánh “if…else if…else”
    public static void main(String[] args) {
        int a = 1;
        if (a > 0) {
            System.out.println("YES"); // YES, vì a > 0
        } else if (a == 0) {
            System.out.println("EQUALS");
        } else {
            System.out.println("NO");
        }
    }
}

/* requirment:
       Viết một chương trình sử dụng câu điều kiện rẽ nhánh if … else if … else để kiểm tra một số có phải là số lớn hơn 0 không?
       Nếu đúng là số lớn hơn 0, thì in ra “YES", nếu bằng 0 thì in ra “EQUALS”, nếu nhỏ hơn 0 thì in ra “NO”.
*/
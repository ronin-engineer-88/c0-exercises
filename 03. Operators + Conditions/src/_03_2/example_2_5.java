package _03_2;

public class example_2_5 {
    // Toán tử ba ngôi
    public static void main(String[] args) {
        int a = 1;
        String result = a > 0 ? "YES" : "NO";

        System.out.println("Giá trị của biến result là: " + result); // Giá trị của biến result là: YES, vì a = 1 > 0
    }
}

/* requirment:
       Viết một chương trình để gán giá trị cho biến result dựa vào giá trị của một số.
       Nếu số đó lớn hơn 0, thì biến result sẽ có giá trị “YES", ngược lại sẽ có giá trị “NO”.
*/
package _09_Exception.homework;

public class _02 {
//    public static void main(String[] args) {
//        System.out.println(1 / 0);
//    }
// => TH này sẽ ném ra ArithmeticException vì chia cho 0.

//    public static void main(String[] args) {
//        int[] list = new int[5];
//        System.out.println(list[5]);
//    }
// => TH này ném ra ArrayIndexOutOfBoundsException vì chỉ số 5 nằm ngoài giới hạn của mảng (mảng có các chỉ số từ 0 đến 4)

//    public static void main(String[] args) {
//        String s = "abc";
//        System.out.println(s.charAt(3));
//    }
// => TH này sẽ ném ra StringIndexOutOfBoundsException vì chỉ số 3 nằm ngoài giới hạn của chuỗi (chuỗi có các chỉ số từ 0 đến 2).

//    public static void main(String[] args) {
//        Object o = new Object();
//        String d = (String)o;
//    }
// => TH này sẽ ném ra ClassCastException vì Object không thể ép kiểu thành String.

//    public static void main(String[] args) {
//        Object o = null;
//        System.out.println(o.toString());
//    }
// => TH này sẽ ném ra NullPointerException vì gọi phương thức trên đối tượng null.

    public static void main(String[] args) {
        System.out.println(1.0 / 0);
    }
// => TH này sẽ không ném ra exception, trong Java phép chia số thực cho 0 sẽ cho kết quả là Infinity (vô cực),
//    không ném ra exception
//
}

// KẾT LUẬN:  Trường hợp (a), (b), (c), (d), và (e) sẽ ném ra exception vì các lý do đã nêu ở trên.
//            Trường hợp (f) sẽ không ném ra exception.
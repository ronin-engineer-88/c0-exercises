package homework;

public class exercise_2 {
    public static void main(String[] args) {
        int number = 10; // khai báo biến, gán giá trị.
        System.out.println("number = " + number);

        // hàm kiểm tra số đó là lẻ or chẵn.
        checkEvenOdd(number);   // - cách 1: sử dụng if-else
        checkEvenOdd1(number);  // - cách 2: sử dụng toán tử 3 ngôi

        // hàm kiểm tra số đó là âm or dương.
        checkPositiveNegative(number);  // - cách 1: sử dụng if-else
        checkPositiveNegative1(number); // - cách 2: sử dụng toán tử 3 ngôi
    }

    public static void checkEvenOdd(int number) {
        if (number % 2 == 0) {
            System.out.println("number là số chẵn.");
        } else {
            System.out.println("number là số lẻ.");
        }
    }

    private static void checkEvenOdd1(int number) {
        String evenOdd = (number % 2 == 0) ? "number là số chẵn." : "number là số lẻ.";
        System.out.println(evenOdd);
    }

    public static void checkPositiveNegative(int number) {
        if (number > 0) {
            System.out.println("number là số dương.");
        } else if (number < 0) {
            System.out.println("number là số âm.");
        } else {
            System.out.println("number = 0");
        }
    }

    private static void checkPositiveNegative1(int number) {
        String result = number > 0 ? "number là số dương." : number < 0 ? "number là số âm." : "number = 0";
        System.out.println(result);
    }
}

/*
 Requirment: Khai báo và gán giá trị cho một biến có kiểu dữ liệu là int.
             Viết chương trình kiểm tra xem biến đó chẵn hay lẻ, âm hay dương,
             in kết quả kiểm tra ra màn hình. Mỗi kết luận trên một dòng
 .*/

// Ý tưởng:  Sử dụng kiến thức đã học: Câu điều kiện rẽ nhánh (Conditions) or
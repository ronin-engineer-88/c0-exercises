package _02_Variable_and_Data_Type;

import java.util.Scanner;

import static java.lang.Math.pow;

public class Exercise05 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

// Thực hiện việc chuyển đổi từ hệ 10 sang hệ 2
        System.out.print("Enter the number you want to convert to the binary form: ");
        int decimalNumber = scanner.nextInt();

        int numerator = decimalNumber; // khởi tạo và gán một biến là tử số để chia
        int quotient = numerator/2; // Khởi tạo và gán một biến là thương sau phép chia lần lượt cho 2
        int remainder = decimalNumber - quotient*2; // Khởi tạo và gán một biến là phần dư
        numerator = quotient; // Sau khi thự hiện phép chia xong tiếp tục gán lại biến tử số bằng thương phép chia để chuẩn bị cho phép chia tiếp theo
        int[] binaryResult = new int[decimalNumber]; // Tạo một mảng để chứa các phần dư sau khi chia xong
        binaryResult[0] = remainder;

        int counter1 = 1; // Tạo biến đếm, thực hiện vòng lặp chia cho đến khi thương bằng 0
        while(numerator > 0){
            quotient = numerator/2;
            remainder = numerator - quotient*2;
            numerator = quotient;
            binaryResult[counter1] = remainder;
            counter1++;
        }

        // Chạy 1 lượt qua mảng để in ra kết quả thu được
        System.out.print("The binary form of " + decimalNumber + " is: ");
        for(int i = counter1; i >0; i--){
            System.out.print(binaryResult[i-1]);
        }
        System.out.println();


// Thực hiện việc chuển đổi từ hệ 2 sang hệ 10
        System.out.print("Enter the binary number you want to convert to the decimal form: ");
        String binaryNumber = scanner.next();

        int length = binaryNumber.length(); // Khởi tạo và gán một biến số lượng bit của số cần chuyển
        int decimalResult = 0; // Tạo ra biến kết quả phép chuyển và ban đầu gán cho nó bằng 0.
        int counter2 = length - 1; // Tạo ra biến đếm và gán nó bằng index(Số phần tử trong mảng) lớn nhất
        // Mảng ở đây là kiểu String chứa các phần tử là các ký tự
        // Index trong một mảng hay cấu trúc dữ liệu nào luôn bắt đầu từ 0 nên index lớn nhất luôn là kích thước mảng - 1

        // Bắt đầu vòng for chạy qua các ký tự của String bit mình nhập và thực hiện phép toán chuyển hệ 2 sang hệ 10
        for(int i = 0; i < length; i++){
            decimalResult += Integer.valueOf(binaryNumber.charAt(i) - '0') * pow(2, counter2);
            counter2--;
        }
        System.out.print("The decimal form of " + binaryNumber + " is: " + decimalResult);

    }
}

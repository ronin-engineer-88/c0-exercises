package _05_Arrays_TextIO.homework;

import java.io.*;
import java.util.Scanner;

public class exercise_5 {
    public static void main(String[] args) {
        String inputFilename = "C:\\file\\input.txt";   // file đầu vào (mình tạo file 'input.txt' trong ổ C)
        String outputFilename = "C:\\file\\output.txt"; // file đầu ra  (mình tạo file 'output.txt' trong ổ C)

        int sum = readAndSumIntegersFromFile(inputFilename); // hàm đọc số nguyên từ file và tính tổng
        writeSumToFile(sum, outputFilename);                 // Gọi hàm ghi kết quả tổng vào file
    }

    public static int readAndSumIntegersFromFile(String filename) {
        int sum = 0;
        try (Scanner scanner = new Scanner(new File(filename))) {
            while (scanner.hasNext()) {
                if (scanner.hasNextInt()) {
                    sum += scanner.nextInt();
                } else {
                    scanner.next(); // Bỏ qua các từ không phải số nguyên
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("File không tồn tại: " + filename);
        }
        return sum;
    }

    public static void writeSumToFile(int sum, String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write("Tổng các số nguyên trong file là: " + sum);
            System.out.println("Ghi kết quả thành công vào file " + filename);
        } catch (IOException e) {
            System.err.println("Lỗi khi ghi dữ liệu vào file: " + e.getMessage());
        }
    }
}
/*
 Requirment: Viết chương trình đọc ra tất cả các số nguyên có trong một file và tính tổng tất cả các số nguyên đó,
             kết quả ghi ra một file text khác.
*/



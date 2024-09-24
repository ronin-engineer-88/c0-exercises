package _05_Arrays_TextIO.homework;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class exercise_4 {
    public static void main(String[] args) {
        int[][][] array = {
                {
                        {1, 2, 3},
                        {4, 5, 6}
                },
                {
                        {7, 8, 9},
                        {10, 11, 12}
                }
        };  // Khởi tạo mảng ba chiều.

        String filename = "ArrayOutput.txt";
        writeArrayToFile(array, filename); // Hàm ghi mảng vào file
    }

    public static void writeArrayToFile(int[][][] array, String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (int i = 0; i < array.length; i++) {
                writer.write("Array layer " + i + ":\n");
                for (int j = 0; j < array[i].length; j++) {
                    for (int k = 0; k < array[i][j].length; k++) {
                        writer.write(array[i][j][k] + " ");
                    }
                    writer.write("\n");
                }
                writer.write("\n");
            }
            System.out.println("Dữ liệu ghi thành công vào file " + filename);
        } catch (IOException e) {
            System.err.println("Lỗi khi ghi dữ liệu vào file: " + e.getMessage());
        }
    }
};

// Requirment: Viết một hàm nhập vào một mảng 3 chiều và in ra ra các giá trị của mảng 3 chiều vào file text.

/*
Idea:
        1. Khởi tạo một mảng ba chiều.
        2. Sử dụng vòng lặp lồng nhau để duyệt qua từng phần tử của mảng.
        3. Sử dụng FileWriter hoặc BufferedWriter để ghi các giá trị vào file văn bản.
*/

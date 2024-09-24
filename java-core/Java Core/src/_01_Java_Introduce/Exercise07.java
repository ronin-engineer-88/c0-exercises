package _01_Java_Introduce;

public class Exercise07 {

    public static void main(String[] args) {
        // Chuyển đổi thời gian chạy từ phút và giây sang giờ
        double timeInHours = 45.0 / 60 + 30.0 / 3600;

        // Chuyển đổi khoảng cách từ km sang dặm
        double distanceInMiles = 14 / 1.6;

        // Tính toán tốc độ trung bình
        double averageSpeed = distanceInMiles / timeInHours;

        System.out.println("Toc do trung binh: " + averageSpeed + " dam/gio");
    }

}

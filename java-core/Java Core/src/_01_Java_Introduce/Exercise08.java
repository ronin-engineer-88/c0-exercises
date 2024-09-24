package _01_Java_Introduce;

public class Exercise08 {
    public static void main(String[] args) {

        System.out.println("Vận động viên chạy 24 dặm trong 1 giờ 40 phút và 35 giây");

        /* Đổi đơn vị: +) 24 dặm = 24 x 1.6 km
                       +) 1 giờ 40 phút 35 giây = 1 + 40 x 1/60 + 35 x 1/3600

           Vận tốc trung bình được tính bằng công thức quãng đường chia cho thời gian
        */

        System.out.print("Tốc độ trung bình của vận động viên tính bằng km/h là: ");
        System.out.printf("%.1f\n", (24*1.6) / (1 + (40*1.0/60) + (35*1.0/3600)));
    }
}

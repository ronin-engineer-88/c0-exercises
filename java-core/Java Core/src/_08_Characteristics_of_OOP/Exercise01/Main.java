package _08_Characteristics_of_OOP.Exercise01;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        QLCB qlcb = new QLCB();

        // Thêm cán bộ
        CongNhan congNhan = new CongNhan("Nguyen Van A", 30, "Nam", "Ha Noi", 5);
        KySu kySu = new KySu("Nguyen Van B", 28, "Nam", "Nghe An", "CNTT");
        NhanVien nhanVien = new NhanVien("Nguyen Van C", 35, "Khác", "Da Nang", "Kế toán");

        qlcb.themCanBo(congNhan);
        qlcb.themCanBo(kySu);
        qlcb.themCanBo(nhanVien);

        // Hiển thị danh sách cán bộ
        System.out.println("Danh sách cán bộ:");
        qlcb.hienThiDanhSachCanBo();

        // Tìm kiếm theo họ tên
        System.out.println("Nhập tên cán bộ cần tìm kiếm:");
        String tenCanTim = scanner.nextLine();
        qlcb.timKiemTheoHoTen(tenCanTim);
    }
}
/*
   Yêu cầu: Xây dựng lớp QLCB(quản lý cán bộ) cài đặt các phương thức thực hiện các chức năng sau:
        Thêm mới cán bộ.
        Tìm kiếm theo họ tên.
        Hiện thị thông tin về danh sách các cán bộ.
*/
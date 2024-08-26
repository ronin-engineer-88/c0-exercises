package _08_Characteristics_of_OOP.Exercise02;

public class Main {
    public static void main(String[] args) {
        QuanLySach quanLySach = new QuanLySach();

        System.out.println(quanLySach.getSize());
        System.out.println(quanLySach.getCapacity());

        quanLySach.themTaiLieu(new Sach(1, "Kim Dong", 5, "Dylan", 100));
        quanLySach.themTaiLieu(new Sach(2, "Nha Nam", 5, "Lisa", 100));
        quanLySach.themTaiLieu(new Sach(3, "IPM", 5, "Rose", 100));
        quanLySach.themTaiLieu(new Sach(4, "NXB Tre", 5, "Jennie", 100));
        quanLySach.themTaiLieu(new Sach(5, "Phuong Nam", 5, "Jisoo", 100));
        System.out.println(quanLySach.getSize());

        quanLySach.themTaiLieu(new Sach(6, "IPM", 5, "Dylan", 100));
        System.out.println(quanLySach.getSize());
        System.out.println(quanLySach.getCapacity());

        quanLySach.hienThiThongTinTaiLieu();
        quanLySach.xoaTaiLieu(5);
        System.out.println(quanLySach.getSize());
        quanLySach.hienThiThongTinTaiLieu();
    }
}

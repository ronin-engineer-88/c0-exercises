package _08_Characteristics_of_OOP.Exercise03;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        QuanLy quanLy = new QuanLy();


        quanLy.themHoGiaDinh(new HoGiaDinh("Ronin Engineer 01", "01", "RN0001"));
        quanLy.themHoGiaDinh(new HoGiaDinh("Ronin Engineer 02", "02", "RN0002"));

        for(int i = 0; i < quanLy.getNumsHoGiaDinh(); i++){
            HoGiaDinh hoGiaDinh = quanLy.getDanhSachHoGiaDinh()[i];
            System.out.println("Biên lai cho hộ gia đình với mã số công tơ điện " + hoGiaDinh.getElectricCode());
            System.out.print("Số điện cũ: " ); Long oldNum = scanner.nextLong();
            System.out.print("Số điện mới: " ); Long newNum = scanner.nextLong();
            quanLy.themBienLai(new BienLai(hoGiaDinh, oldNum, newNum));
        }

        System.out.println("Danh sách biên lai điện của các hộ gia đình: ");
        for(int i = 0; i < quanLy.getNumsBienLai(); i++){
            BienLai bienLai = quanLy.getDanhSachBienLai()[i];
            System.out.println("Chủ hộ " + bienLai.getHoGiaDinh().getFamilyHost() +
                    " với mã công tơ điện " + bienLai.getHoGiaDinh().getElectricCode() +
                    " có hóa đơn tiền điện là: " + bienLai.getPrice());
        }
    }

}

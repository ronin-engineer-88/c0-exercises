package _08_Characteristics_of_OOP.Exercise01;

public class CongNhan extends CanBo {
    private int bac;  // thuộc tính riêng: Bậc (1 đến 10)

    public CongNhan(String hoTen, int tuoi, String gioiTinh, String diaChi, int bac) {
        super(hoTen, tuoi, gioiTinh, diaChi);
        this.bac = bac;
    }

    @Override
    public void hienThiThongTin() {
        super.hienThiThongTin();
        System.out.println("Bậc: " + bac);
    }
}

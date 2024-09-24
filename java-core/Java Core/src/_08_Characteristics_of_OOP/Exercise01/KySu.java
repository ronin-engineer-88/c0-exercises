package _08_Characteristics_of_OOP.Exercise01;

public class KySu extends CanBo {
    private String nganhDaoTao; // thuộc tính riêng: Nghành đào tạo.

    public KySu(String hoTen, int tuoi, String gioiTinh, String diaChi, String nganhDaoTao) {
        super(hoTen, tuoi, gioiTinh, diaChi);
        this.nganhDaoTao = nganhDaoTao;
    }

    @Override
    public void hienThiThongTin() {
        super.hienThiThongTin();
        System.out.println("Ngành đào tạo: " + nganhDaoTao);
    }
}

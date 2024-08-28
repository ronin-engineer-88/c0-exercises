package _08_Characteristics_of_OOP.Exercise03;

public class QuanLy {
    private HoGiaDinh[] danhSachHoGiaDinh;
    private int numsHoGiaDinh;
    private BienLai[] danhSachBienLai;
    private int numsBienLai;
    private int capacity1;
    private int capacity2;

    public QuanLy() {
        this.numsHoGiaDinh = 0;
        this.capacity1 = 1024;
        this.capacity2 = 1024;
        danhSachHoGiaDinh = new HoGiaDinh[capacity1];
        danhSachBienLai = new BienLai[capacity2];
    }

    public void themHoGiaDinh(HoGiaDinh hoGiaDinh) {
        if(numsHoGiaDinh == capacity1){
            this.capacity1 *= 2;
            HoGiaDinh[] copyDanhsachHoGiaDinh = new HoGiaDinh[capacity1];
            for(int i = 0; i < numsHoGiaDinh; i++){
                copyDanhsachHoGiaDinh[i] = danhSachHoGiaDinh[i];
            }
            danhSachHoGiaDinh = copyDanhsachHoGiaDinh;
        }
        danhSachHoGiaDinh[numsHoGiaDinh] = hoGiaDinh;
        numsHoGiaDinh++;
    }

    public HoGiaDinh xoaHoGiaDinh(String electricCode){
        for(int i = 0; i < numsHoGiaDinh; i++){
            if(danhSachHoGiaDinh[i].getElectricCode().equals(electricCode)){
                HoGiaDinh hoGiaDinh = danhSachHoGiaDinh[i];
                for(int j = i; j < numsHoGiaDinh; j++){
                    danhSachHoGiaDinh[j] = danhSachHoGiaDinh[j+1];
                }
                danhSachHoGiaDinh[numsHoGiaDinh - 1] = null;
                numsHoGiaDinh--;
                return hoGiaDinh;
            }
        }
        return null;
    }

    public void suaHoGiaDinh(String electricCode, HoGiaDinh hoGiaDinh){
        for(int i = 0; i < numsHoGiaDinh; i++){
            if(danhSachHoGiaDinh[i].getElectricCode().equals(electricCode)){
                danhSachHoGiaDinh[i].setFamilyHost(hoGiaDinh.getFamilyHost());
                danhSachHoGiaDinh[i].setAddress(hoGiaDinh.getAddress());
                danhSachHoGiaDinh[i].setElectricCode(hoGiaDinh.getElectricCode());
            }
        }
    }

    public void themBienLai(BienLai bienLai) {
        if(numsBienLai == capacity2){
            this.capacity2 *= 2;
            BienLai[] copyDanhsachBienLai = new BienLai[capacity2];
            for(int i = 0; i < numsBienLai; i++){
                copyDanhsachBienLai[i] = danhSachBienLai[i];
            }
            danhSachBienLai = copyDanhsachBienLai;
        }
        danhSachBienLai[numsBienLai] = bienLai;
        numsBienLai++;
    }

// Getter and Setter
    public HoGiaDinh[] getDanhSachHoGiaDinh() {
        return danhSachHoGiaDinh;
    }

    public void setDanhSachHoGiaDinh(HoGiaDinh[] danhSachHoGiaDinh) {
        this.danhSachHoGiaDinh = danhSachHoGiaDinh;
    }

    public int getNumsHoGiaDinh() {
        return numsHoGiaDinh;
    }

    public void setNumsHoGiaDinh(int numsHoGiaDinh) {
        this.numsHoGiaDinh = numsHoGiaDinh;
    }

    public BienLai[] getDanhSachBienLai() {
        return danhSachBienLai;
    }

    public void setDanhSachBienLai(BienLai[] danhSachBienLai) {
        this.danhSachBienLai = danhSachBienLai;
    }

    public int getNumsBienLai() {
        return numsBienLai;
    }

    public void setNumsBienLai(int numsBienLai) {
        this.numsBienLai = numsBienLai;
    }
}

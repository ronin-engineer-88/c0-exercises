package _08_Characteristics_of_OOP.Exercise02;

public class QuanLySach {
    private TaiLieu[] listTaiLieu;
    private int capacity;
    private int size;

    public QuanLySach() {
        this.capacity = 1024;
        this.size = 0;
        listTaiLieu = new TaiLieu[capacity];
    }

    public void themTaiLieu(TaiLieu tailieu){
        if(size == capacity){
            this.capacity *= 2;
            TaiLieu[] copyListTailieu = new TaiLieu[capacity];
            for(int i = 0; i < size; i++){
                copyListTailieu[i] = listTaiLieu[i];
            }
            listTaiLieu = copyListTailieu;
        }
        listTaiLieu[size] = tailieu;
        size++;
    }

    public TaiLieu xoaTaiLieu(int id){
        for(int i = 0; i < size; i++){
            if(listTaiLieu[i].getId() == id){
                TaiLieu taiLieu = listTaiLieu[i];
                for(int j = i; j < size; j++) {
                    listTaiLieu[j] = listTaiLieu[j+1];
                }
                listTaiLieu[size - 1] = null;
                size--;
                return taiLieu;
            }
        }
        return null;
    }

    public void hienThiThongTinTaiLieu(){
        for (int i = 0; i < size; i++) {
            listTaiLieu[i].displayInfo();
            System.out.println("----------------------");
        }
    }

    public void timKiemTheoLoai(String type){
        for(int i = 0; i < size; i++){
            if(type.equalsIgnoreCase("sach") && listTaiLieu[i] instanceof Sach){
                listTaiLieu[i].displayInfo();
                System.out.println("----------------------");
            } else if (type.equalsIgnoreCase("tap chi") && listTaiLieu[i] instanceof TapChi) {
                listTaiLieu[i].displayInfo();
                System.out.println("----------------------");
            } else if (type.equalsIgnoreCase("bao") && listTaiLieu[i] instanceof Bao) {
                listTaiLieu[i].displayInfo();
                System.out.println("----------------------");
            }
        }
    }

}

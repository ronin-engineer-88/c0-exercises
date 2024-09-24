package _08_Characteristics_of_OOP.Exercise03;

public class BienLai {
    private HoGiaDinh hoGiaDinh;
    private long oldNum;
    private long newNum;
    private double price;

    public BienLai(HoGiaDinh hoGiaDinh, long oldNum, long newNum) {
        this.hoGiaDinh = hoGiaDinh;
        this.oldNum = oldNum;
        this.newNum = newNum;
        this.price = electricPrice();
    }

    public double electricPrice(){
        return (newNum - oldNum)*5;
    }
    public HoGiaDinh getHoGiaDinh() {
        return hoGiaDinh;
    }

    public void setHoGiaDinh(HoGiaDinh hoGiaDinh) {
        this.hoGiaDinh = hoGiaDinh;
    }

    public long getOldNum() {
        return oldNum;
    }

    public void setOldNum(long oldNum) {
        this.oldNum = oldNum;
    }

    public long getNewNum() {
        return newNum;
    }

    public void setNewNum(long newNum) {
        this.newNum = newNum;
    }

    public double getPrice() {
        return price;
    }
}

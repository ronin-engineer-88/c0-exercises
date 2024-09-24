package _08_Characteristics_of_OOP.Exercise02;

public class Bao extends TaiLieu {
    private String dateRelease;

    public Bao(int id, String publisher, int copies, String dateRelease) {
        super(id, publisher, copies);
        this.dateRelease = dateRelease;
    }

    public String getDateRelease() {
        return dateRelease;
    }

    public void setDateRelease(String dateRelease) {
        this.dateRelease = dateRelease;
    }

    @Override
    public void displayInfo(){
        super.displayInfo();
        System.out.println("Ngày phát hành: " + dateRelease);
    }
}

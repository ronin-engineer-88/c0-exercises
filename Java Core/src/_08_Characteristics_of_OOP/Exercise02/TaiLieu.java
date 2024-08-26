package _08_Characteristics_of_OOP.Exercise02;

public abstract class TaiLieu {
    private int id;
    private String publisher;
    private int copies;

    public TaiLieu(int id, String publisher, int copies) {
        this.id = id;
        this.publisher = publisher;
        this.copies = copies;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getCopies() {
        return copies;
    }

    public void setCopies(int copies) {
        this.copies = copies;
    }

    public void displayInfo() {
        System.out.println("Mã tài liệu: " + id);
        System.out.println("Tên nhà xuất bản: " + publisher);
        System.out.println("Số bản phát hành: " + copies);
    }
}

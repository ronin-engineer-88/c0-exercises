package _08_Characteristics_of_OOP.Exercise02;

public class Sach extends TaiLieu {
    private String author;
    private int numPages;

    public Sach(int id, String publisher, int copies, String author, int numPages) {
        super(id, publisher, copies);
        this.author = author;
        this.numPages = numPages;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getNumPages() {
        return numPages;
    }

    public void setNumPages(int numPages) {
        this.numPages = numPages;
    }

    @Override
    public void displayInfo(){
        super.displayInfo();
        System.out.println("Tên tác giả: " + author);
        System.out.println("Số trang: " + numPages);
    }
}

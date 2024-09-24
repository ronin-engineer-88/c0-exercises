package _09_ClassDesign_and_WrapperClass.AgressionRelation;
public class Library {
    private Book book;
    private Document document;

    public Library(Book book, Document document) {
        this.book = book;
        this.document = document;
    }

    public void readBook(){
        System.out.println("Read Book");
    }

    public void readDocument(){
        System.out.println("Read Document");
    }
    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }
}

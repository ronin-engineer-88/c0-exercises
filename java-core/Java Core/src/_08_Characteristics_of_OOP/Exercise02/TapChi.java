package _08_Characteristics_of_OOP.Exercise02;

public class TapChi extends TaiLieu{
    private int issue;
    private int monthRelease;

    public TapChi(int id, String publisher, int copies, int issue, int monthRelease) {
        super(id, publisher, copies);
        this.issue = issue;
        this.monthRelease = monthRelease;
    }

    public int getIssue() {
        return issue;
    }

    public void setIssue(int issue) {
        this.issue = issue;
    }

    public int getMonthRelease() {
        return monthRelease;
    }

    public void setMonthRelease(int monthRelease) {
        this.monthRelease = monthRelease;
    }

    @Override
    public void displayInfo(){
        super.displayInfo();
        System.out.println("Số phát hành: " + issue);
        System.out.println("Tháng phát hành: " + monthRelease);
    }
}

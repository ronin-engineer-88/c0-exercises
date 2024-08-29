package _08_Characteristics_of_OOP.Exercise04;

public class Main {
    public static void main(String[] args) {
        Student goodStudent = new GoodStudent(
                "Nguyen Van A", "01/01/1998", "Nam", "0123456789",
                "Dai hoc kien truc", "Gioi", 8.5, "Hoc bong A"
        );

        Student normalStudent = new NormalStudent(
                "Nguyen Van B", "02/02/1997", "Nữ", "0987654321",
                "Dai hoc xay dung", "Trung binh", 700, 6.5
        );

        System.out.println("Thông tin sinh viên tốt nghiệp khá giỏi:");
        goodStudent.showMyInfor();

        System.out.println("\nThông tin sinh viên tốt nghiệp trung bình:");
        normalStudent.showMyInfor();
    }
}

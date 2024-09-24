package _08_Characteristics_of_OOP.Exercise04;

public class NormalStudent extends Student {
    private int englishScore;
    private double entryTestScore;

    public NormalStudent(String fullName, String doB, String sex, String phoneNumber, String universityName,
                         String gradeLevel, int englishScore, double entryTestScore) {
        super(fullName, doB, sex, phoneNumber, universityName, gradeLevel);
        this.englishScore = englishScore;
        this.entryTestScore = entryTestScore;
    }

    @Override
    public void showMyInfor() {
        System.out.println("Họ tên: " + getFullName());
        System.out.println("Ngày sinh: " + getDoB());
        System.out.println("Giới tính: " + getSex());
        System.out.println("Số điện thoại: " + getPhoneNumber());
        System.out.println("Trường đại học: " + getUniversityName());
        System.out.println("Xếp loại tốt nghiệp: " + getGradeLevel());
        System.out.println("Điểm TOEIC: " + englishScore);
        System.out.println("Điểm thi đầu vào chuyên môn: " + entryTestScore);
    }
}

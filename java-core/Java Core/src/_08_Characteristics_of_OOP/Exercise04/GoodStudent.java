package _08_Characteristics_of_OOP.Exercise04;

public class GoodStudent extends Student {
    private double gpa;
    private String bestRewardName;

    public GoodStudent(String fullName, String doB, String sex, String phoneNumber, String universityName,
                       String gradeLevel, double gpa, String bestRewardName) {
        super(fullName, doB, sex, phoneNumber, universityName, gradeLevel);
        this.gpa = gpa;
        this.bestRewardName = bestRewardName;
    }

    @Override
    public void showMyInfor() {
        System.out.println("Họ tên: " + getFullName());
        System.out.println("Ngày sinh: " + getDoB());
        System.out.println("Giới tính: " + getSex());
        System.out.println("Số điện thoại: " + getPhoneNumber());
        System.out.println("Trường đại học: " + getUniversityName());
        System.out.println("Xếp loại tốt nghiệp: " + getGradeLevel());
        System.out.println("GPA: " + gpa);
        System.out.println("Giải thưởng tốt nhất: " + bestRewardName);
    }
}

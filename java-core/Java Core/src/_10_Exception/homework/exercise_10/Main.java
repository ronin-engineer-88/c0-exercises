package _10_Exception.homework.exercise_10;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Management management = new Management();
        Scanner scanner = new Scanner(System.in);
        int choice = -1;

        do {
            System.out.println("=== MENU ===");
            System.out.println("1. Thêm sinh viên");
            System.out.println("2. Xóa sinh viên");
            System.out.println("3. Tìm sinh viên theo ID");
            System.out.println("4. Hiển thị danh sách sinh viên");
            System.out.println("5. Thoát");
            System.out.print("Chọn một chức năng: ");

            try {
                choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 1:
                        System.out.print("Nhập ID: ");
                        String id = scanner.nextLine();
                        System.out.print("Nhập tên: ");
                        String name = scanner.nextLine();
                        System.out.print("Nhập khoa: ");
                        String department = scanner.nextLine();
                        System.out.print("Nhập GPA: ");
                        double gpa = scanner.nextDouble();
                        Student student = new Student(id, name, department, gpa);
                        management.add(student);
                        System.out.println("Thêm sinh viên thành công!");
                        break;
                    case 2:
                        System.out.print("Nhập chỉ số sinh viên cần xóa: ");
                        int index = scanner.nextInt();
                        management.remove(index);
                        System.out.println("Xóa sinh viên thành công!");
                        break;
                    case 3:
                        System.out.print("Nhập ID sinh viên: ");
                        String searchId = scanner.nextLine();
                        Student foundStudent = management.searchStudent(searchId);
                        System.out.println("Thông tin sinh viên: " + foundStudent);
                        break;
                    case 4:
                        management.displayStudentList();
                        break;
                    case 5:
                        System.out.println("Thoát chương trình.");
                        break;
                    default:
                        System.out.println("Lựa chọn không hợp lệ, vui lòng chọn lại.");
                }
            } catch (InputMismatchException ex) {
                System.out.println("Vui lòng nhập số nguyên hợp lệ!");
                scanner.next();
            } catch (InvalidStudentException | EmptyStudentException ex) {
                System.out.println(ex.getMessage());
            }
        } while (choice != 5);

        scanner.close();
    }
}

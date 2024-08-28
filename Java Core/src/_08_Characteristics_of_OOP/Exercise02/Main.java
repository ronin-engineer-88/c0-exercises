package _08_Characteristics_of_OOP.Exercise02;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        QuanLySach quanLySach = new QuanLySach();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            printMenu();
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1: {
                    System.out.print("Nhập loại tài liệu (Sach, Tap Chi, Bao): ");
                    String type = scanner.nextLine();

                    if (!type.equalsIgnoreCase("Sach") &&
                            !type.equalsIgnoreCase("Tap Chi") &&
                            !type.equalsIgnoreCase("Bao")) {
                        System.out.println("Loại tài liệu không hợp lệ!");
                    } else {
                        quanLySach.themTaiLieu(newDocument(scanner, type));
                    }
                }
                    break;
                case 2:
                    System.out.print("Nhập mã tài liệu cần xoá: ");
                    int id = scanner.nextInt();
                    if(quanLySach.xoaTaiLieu(id) != null){
                        System.out.println("Xoá thành công");
                    } else {
                        System.out.println("Không tồn tại tài liệu trùng với mã cần xóa!");
                    }
                    break;
                case 3:
                    quanLySach.hienThiThongTinTaiLieu();
                    break;
                case 4: {
                    System.out.print("Nhập loại tài liệu cần tìm (Sach, Tap Chi, Bao): ");
                    String type = scanner.nextLine();
                    quanLySach.timKiemTheoLoai(type);
                }
                    break;
                case 0:
                    System.out.println("Thoát chương trình.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        } while(choice != 0);
    }

    private static void printMenu() {
        System.out.println("MENU:");
        System.out.println("1. Thêm mới tài liệu");
        System.out.println("2. Xoá tài liệu");
        System.out.println("3. Hiển thị thông tin tài liệu");
        System.out.println("4. Tìm kiếm tài liệu theo loại");
        System.out.println("0. Thoát");
        System.out.print("Nhâp lựa chọn của bạn: ");
    }

    private static TaiLieu newDocument(Scanner scanner, String type){
        TaiLieu taiLieu = null;
        System.out.print("Nhập mã tài liệu: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Nhập tên nhà xuất bản: ");
        String publisher = scanner.nextLine();
        System.out.print("Nhập số bản phát hành: ");
        int copies = scanner.nextInt();
        scanner.nextLine();

        if(type.equalsIgnoreCase("sach")){
            System.out.print("Nhập tên tác giả: ");
            String author = scanner.nextLine();
            System.out.print("Nhập số trang: ");
            int numPages = scanner.nextInt();

            scanner.nextLine();
            taiLieu = new Sach(id, publisher, copies, author, numPages);

        } else if(type.equalsIgnoreCase("Tap Chi")){
            System.out.print("Nhập số phát hành: ");
            int issue = scanner.nextInt();
            System.out.print("Nhập tháng phát hành: ");
            int monthRelease = scanner.nextInt();

            scanner.nextLine();
            taiLieu = new TapChi(id, publisher, copies, issue, monthRelease);

        } else if(type.equalsIgnoreCase("Bao")){
            System.out.print("Nhập ngày phát hành: ");
            String dateRelease = scanner.nextLine();
            taiLieu = new Bao(id, publisher, copies, dateRelease);
        }

        return taiLieu;
    }

}

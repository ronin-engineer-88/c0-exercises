package _07_Characteristics_of_OOP.homework;

import _07_Characteristics_of_OOP.homework.models.Housekeeper;
import _07_Characteristics_of_OOP.homework.models.Receptionist;
import _07_Characteristics_of_OOP.homework.models.Room;

public class HotelManagement {
    public static void main(String[] args) {
        // Create room
        Room room101 = new Room();
        room101.configureRoom(101, "Phòng đơn");

        Room room102 = new Room();
        room102.configureRoom(102, "Phòng đôi");

        // Create employee
        Receptionist receptionist = new Receptionist(1, "An");
        Housekeeper housekeeper = new Housekeeper(2, "Bình");

        // asign phòng cho nhân viên phụ trách
        receptionist.assignRoom(room101);
        receptionist.assignRoom(room102, "ưu tiên");

        housekeeper.assignRoom(room101);
        housekeeper.assignRoom(room102, true);

        // Xem danh sách phòng mà nhân viên phụ trách
        System.out.println("\nPhòng được quản lý bởi nhân viên: " + receptionist.getName());
        for (Room room : receptionist.getRoomsInCharge()) {
            System.out.println("Room Number: " + room.getRoomNumber() + ", Room Type: " + room.getRoomType());
        }

        System.out.println("\nPhòng được quản lý bởi nhân viên :" + housekeeper.getName());
        for (Room room : housekeeper.getRoomsInCharge()) {
            System.out.println("Room Number: " + room.getRoomNumber() + ", Room Type: " + room.getRoomType());
        }

        // Tính lương nhân viên
        System.out.println("\nSalary of Receptionist An: " + receptionist.calculateSalary());
        System.out.println("Salary of Housekeeper Bình: " + housekeeper.calculateSalary());
    }
}

/*
    Ngữ cảnh: Hệ thống quản lý khách sạn.
        Đối tượng: lễ tân, lao công, quản lý, khách sạn, phòng, …
    Thành phần:
        Ít nhất 1 abstract class
        Ít nhất 2 interface
        Override, overload ít nhất 1 method
    Tính năng:
        Cấu hình phòng
        Cấu hình nhân viên: id, name…
        Gắn phòng cho 1 nhân viên phụ trách
        Xem danh sách phòng mà 1 nhân viên phụ trách
        Tính lương dựa vào số phòng phụ trách và trọng số
*/

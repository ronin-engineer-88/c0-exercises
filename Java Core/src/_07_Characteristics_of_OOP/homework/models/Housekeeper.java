package _07_Characteristics_of_OOP.homework.models;

public class Housekeeper extends Employee {
    private static final double BASE_SALARY = 200;

    @Override
    public double calculateSalary() { // hàm tính lương.
        return BASE_SALARY + getRoomsInCharge().size() * 15;
    }

    public void assignRoom(Room room, boolean isUrgent) { // overload method
        super.assignRoom(room);
        if (isUrgent) {
            System.out.println("Đã giao phòng: " + room.getRoomNumber());
        }
    }

    public Housekeeper(int id, String name) {
        super(id, name);
    }
}
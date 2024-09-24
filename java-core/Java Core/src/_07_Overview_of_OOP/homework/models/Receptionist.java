package _07_Overview_of_OOP.homework.models;

public class Receptionist extends Employee {
    private static final double BASE_SALARY = 300;

    public Receptionist(int id, String name) {
        super(id, name);
    }

    @Override
    public double calculateSalary() {
        return BASE_SALARY + getRoomsInCharge().size() * 20;
    }

    public void assignRoom(Room room, String additionalInfo) { // Overloaded method
        super.assignRoom(room);
        System.out.println("Thông tin bổ sung cho p" + room.getRoomNumber() + " : " + additionalInfo);
    }
}
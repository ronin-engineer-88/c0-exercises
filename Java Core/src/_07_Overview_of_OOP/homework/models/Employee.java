package _07_Overview_of_OOP.homework.models;

import _07_Overview_of_OOP.homework.interfaces.IEmployeeInCharge;

import java.util.ArrayList;
import java.util.List;

public abstract class Employee implements IEmployeeInCharge {
    private int id;
    private String name;
    private List<Room> roomsInCharge;

    @Override
    public void assignRoom(Room room) {
        roomsInCharge.add(room);
    }

    @Override
    public List<Room> getRoomsInCharge() {
        return roomsInCharge;
    }

    public abstract double calculateSalary(); // abstract method

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
        this.roomsInCharge = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
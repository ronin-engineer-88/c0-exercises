package _07_Overview_of_OOP.homework.models;

import _07_Overview_of_OOP.homework.interfaces.IRoom;

public class Room implements IRoom {
    private int roomNumber;
    private String roomType;

    public int getRoomNumber() {
        return roomNumber;
    }

    public String getRoomType() {
        return roomType;
    }

    @Override
    public void configureRoom(int roomNumber, String roomType) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
    }
}
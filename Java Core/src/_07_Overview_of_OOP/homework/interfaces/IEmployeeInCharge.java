package _07_Overview_of_OOP.homework.interfaces;

import _07_Overview_of_OOP.homework.models.Room;

import java.util.List;

public interface IEmployeeInCharge {
    void assignRoom(Room room);
    List<Room> getRoomsInCharge();
}

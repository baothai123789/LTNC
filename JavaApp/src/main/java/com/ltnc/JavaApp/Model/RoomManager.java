package com.ltnc.JavaApp.Model;
import java.util.ArrayList;
import java.util.List;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "RoomManager")
public class RoomManager extends FunctionalEmployee{
    private final List<Room> rooms;
    public RoomManager() {
        this.rooms = new ArrayList<>();
        this.role = "RoomManager";
    }
    public void addRoom(Room room) {
        rooms.add(room);
    }
    public int countRooms() {
        return rooms.size();
    }

    public void printAllRooms() {
        System.out.println("List of all rooms:");
        for (Room room : rooms) {
            System.out.println(room.toString());
        }
    }
}

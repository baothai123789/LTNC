package com.ltnc.JavaApp.Service;

import com.ltnc.JavaApp.Model.Patient;
import com.ltnc.JavaApp.Model.Person;
import com.ltnc.JavaApp.Model.PharmacyManager;
import com.ltnc.JavaApp.Model.Room;
import com.ltnc.JavaApp.Repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomService implements IInfomationService{
    private final RoomRepository roomRepository;
    @Autowired
    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }


    public void addPatientToRoom(String roomId, Patient patient) {
        Room room = roomRepository.findById(roomId).orElseThrow(() -> new RuntimeException("Room not found"));
        List<Patient> patientList = room.getPatientList();

        if (patientList.size() < room.getCapacity()) {
            patientList.add(patient);
            room.setPatientList(patientList);
            roomRepository.save(room);
            System.out.println("Patient " + patient.getName() + " added to the room.");
        } else {
            System.out.println("Room is full. Cannot add more patients.");
        }
    }

    public void removePatientFromRoom(String roomId, String patientId) {
        Room room = roomRepository.findById(roomId).orElseThrow(() -> new RuntimeException("Room not found"));
        List<Patient> patientList = room.getPatientList();
        patientList.removeIf(patient -> patient.getId().equals(patientId));
        room.setPatientList(patientList);
        roomRepository.save(room);
    }

    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    public Room getRoomById(String roomId) {
        return roomRepository.findById(roomId).orElseThrow(() -> new RuntimeException("Room not found"));
    }
    public void printIDRoom(){
        System.out.println(roomRepository.toString());
    }

    @Override
    public Optional<Person> getData(String id) {
        return Optional.empty();
    }
}

package com.ltnc.JavaApp.Controller;

import com.ltnc.JavaApp.Model.Patient;
import com.ltnc.JavaApp.Model.Room;
import com.ltnc.JavaApp.Service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/rooms")
public class RoomController {
    private final RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }
    @GetMapping
    public ResponseEntity<List<Room>> getAllRooms() {
        List<Room> rooms = roomService.getAllRooms();
        return new ResponseEntity<>(rooms, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Room> getRoomById(@PathVariable("id") String id) {
        Room room = roomService.getRoomById(id);
        return new ResponseEntity<>(room, HttpStatus.OK);
    }

    @PostMapping("/{id}/addPatient")
    public ResponseEntity<String> addPatientToRoom(@PathVariable("id") String roomId, @RequestBody Patient patient) {
        roomService.addPatientToRoom(roomId, patient);
        return new ResponseEntity<>("Patient added to room successfully", HttpStatus.CREATED);
    }

    @DeleteMapping("/{roomId}/removePatient/{patientId}")
    public ResponseEntity<String> removePatientFromRoom(@PathVariable("roomId") String roomId, @PathVariable("patientId") String patientId) {
        roomService.removePatientFromRoom(roomId, patientId);
        return new ResponseEntity<>("Patient removed from room successfully", HttpStatus.OK);
    }
}

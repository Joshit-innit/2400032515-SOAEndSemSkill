package com.klef.ms.sem.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.klef.ms.sem.entity.Room;
import com.klef.ms.sem.service.RoomService;

@RestController
@RequestMapping("/rooms")
public class RoomController {

    @Autowired
    private RoomService roomService;


    @PostMapping("/add")
    public Room addRoom(@RequestBody Room room) {
        return roomService.addRoom(room);
    }

    @GetMapping("/all")
    public List<Room> getAllRooms() {
        return roomService.getAllRooms();
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> getRoomById(@PathVariable Long id) {

    	Optional<Room> room = roomService.getRoomById(id);

        if (room.isPresent()) {
            return ResponseEntity.ok(room.get());
        } 
        else {
            return ResponseEntity.status(404).body("Room ID not found");
        }
    }
}
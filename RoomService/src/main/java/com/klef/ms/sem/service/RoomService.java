package com.klef.ms.sem.service;


import java.util.List;
import java.util.Optional;

import com.klef.ms.sem.entity.Room;

public interface RoomService {

    Room addRoom(Room room);

    List<Room> getAllRooms();

    Optional<Room> getRoomById(Long id);
}

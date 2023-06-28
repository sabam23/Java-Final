package com.exam.sabamchedlishvili.services.impl;

import com.exam.sabamchedlishvili.dto.ApiResponse;
import com.exam.sabamchedlishvili.dto.RoomDTO;
import com.exam.sabamchedlishvili.entities.Hotel;
import com.exam.sabamchedlishvili.entities.RecordState;
import com.exam.sabamchedlishvili.entities.Room;
import com.exam.sabamchedlishvili.repositories.HotelRepository;
import com.exam.sabamchedlishvili.repositories.RoomRepository;
import com.exam.sabamchedlishvili.services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomServiceImpl implements RoomService {
    private final RoomRepository roomRepository;
    private final HotelRepository hotelRepository;
    @Autowired
    public RoomServiceImpl(RoomRepository roomRepository, HotelRepository hotelRepository) {
        this.roomRepository = roomRepository;
        this.hotelRepository = hotelRepository;
    }
    @Override
    public ApiResponse addRoom(RoomDTO roomDto) {
        Room room = new Room();
        room.setRoomNumber(roomDto.getRoomNumber());
        room.setRecordState(RecordState.ACTIVE);
        room.setPrice(roomDto.getPrice());
        room.setHotel(hotelRepository.getById(roomDto.getHotelId()));
        return new ApiResponse("room",roomRepository.save(room));
    }

    @Override
    public ApiResponse getAll() {
        return new ApiResponse("rooms",roomRepository.getAll());
    }
}

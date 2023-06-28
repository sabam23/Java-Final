package com.exam.sabamchedlishvili.services;

import com.exam.sabamchedlishvili.dto.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface HotelService {
    ApiResponse add(HotelDTO hotel);

    ApiResponse getAllHotel();

    ApiResponse getFreeRooms(Long id);
    List<RoomDTO> getRoomsByHotel(List<Long> hotelIds);

    ApiResponse stats();
}

package com.exam.sabamchedlishvili.services;

import com.exam.sabamchedlishvili.dto.ApiResponse;
import com.exam.sabamchedlishvili.dto.RoomDTO;

public interface RoomService {
    ApiResponse addRoom(RoomDTO room);
    ApiResponse getAll();
}

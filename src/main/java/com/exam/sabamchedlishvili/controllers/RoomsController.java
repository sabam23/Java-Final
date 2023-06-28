package com.exam.sabamchedlishvili.controllers;

import com.exam.sabamchedlishvili.dto.ApiResponse;
import com.exam.sabamchedlishvili.dto.RoomDTO;
import com.exam.sabamchedlishvili.services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/room")
public class RoomsController {
    private final RoomService roomService;
    @Autowired
    public RoomsController(RoomService roomService) {
        this.roomService = roomService;
    }
    @PostMapping(value = "/add")
    public ApiResponse addRoom(@RequestBody RoomDTO dto){
        return this.roomService.addRoom(dto);
    }
    @GetMapping(value = "/getAllRooms")
    public ApiResponse getRooms(){
        return this.roomService.getAll();
    }

}

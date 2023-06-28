package com.exam.sabamchedlishvili.controllers;

import com.exam.sabamchedlishvili.dto.ApiResponse;
import com.exam.sabamchedlishvili.dto.HotelDTO;
import com.exam.sabamchedlishvili.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hotel")
public class HotelsController {
    private final HotelService hotelService;

    @Autowired
    public HotelsController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @PostMapping(value = "/add")
    public ApiResponse addHotel(@RequestBody HotelDTO dto){
        return this.hotelService.add(dto);
    }

    @GetMapping(value = "/getAllHotel")
    public ApiResponse getHotel(){
        return this.hotelService.getAllHotel();
    }
    @GetMapping(value = "/getFreeRooms/{id}")
    public ApiResponse getFreeRooms(@PathVariable Long id){
        return this.hotelService.getFreeRooms(id);
    }

    @GetMapping(value = "/getSales")
    public ApiResponse getSales(){
        return this.hotelService.stats();
    }

}

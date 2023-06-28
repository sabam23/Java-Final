package com.exam.sabamchedlishvili.controllers;

import com.exam.sabamchedlishvili.dto.ApiResponse;
import com.exam.sabamchedlishvili.dto.ReservationDTO;
import com.exam.sabamchedlishvili.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reservation")
public class ReservedController {
    private final ReservationService reservationService;
    @Autowired
    public ReservedController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public ApiResponse addReservation(@RequestBody ReservationDTO dto){
        return this.reservationService.addReserv(dto);
    }
    @GetMapping(value = "/getAllReservations")
    public ApiResponse getReservations(){
        return this.reservationService.getReservations();
    }
    @GetMapping(value = "/getBusyRooms")
    public ApiResponse getBusyRooms(){
        return this.reservationService.getReservedRooms();
    }
    @GetMapping(value = "/getFreeRooms")
    public ApiResponse getFreeRooms(){
        return this.reservationService.getFreeRooms();
    }
}

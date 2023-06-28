package com.exam.sabamchedlishvili.services;

import com.exam.sabamchedlishvili.dto.ApiResponse;
import com.exam.sabamchedlishvili.dto.ReservationDTO;

public interface ReservationService {
    ApiResponse addReserv(ReservationDTO roomReservation);
    ApiResponse getReservations();

    ApiResponse getFreeRooms();

    ApiResponse getReservedRooms();
}
